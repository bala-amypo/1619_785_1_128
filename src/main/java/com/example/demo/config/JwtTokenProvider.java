package com.example.demo.config;

import org.springframework.security.core.Authentication;
import java.util.Base64;

public class JwtTokenProvider {

    private final String secret;
    private final Long validity;

    public JwtTokenProvider(String secret, Long validity) {
        this.secret = secret;
        this.validity = validity;
    }

    public String generateToken(Authentication auth, Object user) {
        return Base64.getEncoder().encodeToString(
                (auth.getName() + ":" + validity).getBytes()
        );
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return token.contains(":");
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        return new String(Base64.getDecoder().decode(token)).split(":")[0];
    }
}
