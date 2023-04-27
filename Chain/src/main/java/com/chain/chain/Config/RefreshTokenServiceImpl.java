package com.chain.chain.Config;

import com.chain.chain.Domain.Entity.User.PersonalCustomer;
import com.chain.chain.Domain.JwtTokenDto;
import com.chain.chain.Domain.RefreshToken;
import com.chain.chain.Exception.AccessTokenNotValidException;
import com.chain.chain.Exception.NotExistUserException;
import com.chain.chain.Exception.RefreshTokenNotValidException;
import com.chain.chain.Repository.User.RefreshTokenRedisRepository;
import com.chain.chain.Repository.UserCard.UserRepositoryImpl;
import com.chain.chain.Service.RefreshTokenService;
import com.chain.chain.Service.UserLoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Component
public class RefreshTokenServiceImpl implements RefreshTokenService {
    @Autowired
    private  UserRepositoryImpl userRepository;
    @Autowired
    private  RefreshTokenRedisRepository refreshTokenRedisRepository;
    private static final Logger log = LoggerFactory.getLogger(RefreshTokenServiceImpl.class);
    @Autowired
    private  ObjectMapper objectMapper;
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  JwtTokenProvider jwtTokenProvider;
    @Autowired
    private  RefreshTokenServiceImpl refreshTokenServiceImpl;
    @Autowired
    private  CookieProvider cookieProvider;
    @Autowired
    private  UserLoginService userLoginService;

    @Transactional
    @Override
    public void updateRefreshToken(UUID id, String uuid) throws NotExistUserException {
        PersonalCustomer user = userRepository.findById(id)
                .orElseThrow(() -> new NotExistUserException("사용자 고유번호 : " + id + "는 없는 사용자입니다."));

        refreshTokenRedisRepository.save(RefreshToken.of(user.getBirth().toString(), uuid));
    }

    @Transactional
    @Override
    public JwtTokenDto refreshJwtToken(String accessToken, String refreshToken) throws RefreshTokenNotValidException {
        String userId = jwtTokenProvider.getUserId(accessToken);

        RefreshToken findRefreshToken = null;
        try {
            findRefreshToken = refreshTokenRedisRepository.findById(userId)
                    .orElseThrow(()
                            -> new RefreshTokenNotValidException("사용자 고유번호 : " + userId + "는 등록된 리프레쉬 토큰이 없습니다.")
                    );
        } catch (RefreshTokenNotValidException e) {
        }

        // refresh token 검증
        String findRefreshTokenId = findRefreshToken.getRefreshTokenId();
        if (!jwtTokenProvider.validateJwtToken(refreshToken)) {
            refreshTokenRedisRepository.delete(findRefreshToken);
            throw new RefreshTokenNotValidException("Not validate jwt token = " + refreshToken);
        }

        if (!jwtTokenProvider.equalRefreshTokenId(findRefreshTokenId, refreshToken)) {
            throw new RefreshTokenNotValidException("redis 의 값과 일치하지 않습니다. = " + refreshToken);
        }

        PersonalCustomer findUser = null;
        try {
            findUser = userRepository.findById(UUID.fromString(userId))
                    .orElseThrow(() -> new NotExistUserException("유저 고유 번호 : " + userId + "는 없는 유저입니다."));
        } catch (NotExistUserException e) {
            e.printStackTrace();
        }

        // access token 생성
        Authentication authentication = getAuthentication(findUser.getEmail());
        List<String> roles = authentication.getAuthorities()
                .stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        String newAccessToken = jwtTokenProvider.createJwtAccessToken(userId, "/reissu", roles);
        Date expiredTime = jwtTokenProvider.getClaimsFromJwtToken(newAccessToken).getExpiration();

        return JwtTokenDto.builder()
                .accessToken(newAccessToken)
                .accessTokenExpiredDate(expiredTime)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public void logoutToken(String accessToken) {
        if (!jwtTokenProvider.validateJwtToken(accessToken)) {
            // 예외 발생
            try {
                throw  new AccessTokenNotValidException("access token is not valid");
            } catch (AccessTokenNotValidException e) {
                e.printStackTrace();

            }
        }

        RefreshToken refreshToken = null;
        try {
            refreshToken = refreshTokenRedisRepository.findById(jwtTokenProvider.getUserId(accessToken))
                    .orElseThrow(() -> new RefreshTokenNotValidException("refresh Token is not exist"));
        } catch (RefreshTokenNotValidException e) {
            e.printStackTrace();
        }

        refreshTokenRedisRepository.delete(refreshToken);
    }

    public Authentication getAuthentication(String email) {
        UserDetails userDetails = userLoginService.loadUserByUsername(email);
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }
}