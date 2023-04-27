package com.chain.chain.Service;

import com.chain.chain.Domain.JwtTokenDto;
import com.chain.chain.Exception.NotExistUserException;
import com.chain.chain.Exception.RefreshTokenNotValidException;


import java.util.UUID;

public interface RefreshTokenService {
    void updateRefreshToken(UUID id, String uuid) throws NotExistUserException;
    JwtTokenDto refreshJwtToken(String accessToken, String refreshToken) throws RefreshTokenNotValidException;
    void logoutToken(String accessToken);
}
