package com.chain.chain.Config;

import javax.persistence.*;
import javax.servlet.http.Cookie;
import javax.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class CookieProvider {


    private Long refreshTokenExpiredTime = 1000L;

    public ResponseCookie createRefreshTokenCookie(String refreshToken) {
        return ResponseCookie.from("refresh-token", refreshToken)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(refreshTokenExpiredTime).build();
    }

    public ResponseCookie removeRefreshTokenCookie() {
        return ResponseCookie.from("refresh-token", null)
                .build();
    }

    public Cookie of(ResponseCookie responseCookie) {
        Cookie cookie = new Cookie(responseCookie.getName(), responseCookie.getValue());
        cookie.setPath(responseCookie.getPath());
        cookie.setSecure(responseCookie.isSecure());
        cookie.setHttpOnly(responseCookie.isHttpOnly());
        cookie.setMaxAge((int) responseCookie.getMaxAge().getSeconds());
        return cookie;
    }
}
