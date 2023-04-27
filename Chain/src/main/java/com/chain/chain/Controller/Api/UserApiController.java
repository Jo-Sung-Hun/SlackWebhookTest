package com.chain.chain.Controller.Api;


import com.chain.chain.Config.JwtTokenProvider;
import com.chain.chain.Domain.DTO.User.PersonalCustomerDTO;
import com.chain.chain.Domain.Entity.User.PersonalCustomer;
import com.chain.chain.Service.UserLoginService;
import com.chain.chain.Service.UserRepositoryServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public class UserApiController {
    private static final Logger logger = LoggerFactory.getLogger(UserApiController.class);
    private final ObjectMapper objectMapper;
    private final UserLoginService userLoginService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepositoryServiceImpl userRepositoryService;

    @Autowired
    public UserApiController(ObjectMapper objectMapper, UserLoginService userLoginService, JwtTokenProvider jwtTokenProvider, UserRepositoryServiceImpl userRepositoryService) {
        this.objectMapper = objectMapper;
        this.userLoginService = userLoginService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepositoryService = userRepositoryService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST )
    public Object setCard(@RequestBody @NotNull String json, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)  {
        try {
            PersonalCustomerDTO result = objectMapper.readValue(json, PersonalCustomerDTO.class);

            UserDetails userDetails = userLoginService.loadUserByUsername(result.getNickName());
            Optional<PersonalCustomer> personalCustomer = userRepositoryService.findByUsername(userDetails.getUsername());
            String refreshToken = jwtTokenProvider.createJwtRefreshToken();
            String accessToken = jwtTokenProvider.createJwtAccessToken(personalCustomer.get().getId().toString(), , userDetails.getUsername());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "card";
    }
}
