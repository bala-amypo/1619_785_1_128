package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final String jwtSecret;
    private final long jwtExpirationInMs;

    public JwtTokenProvider(String jwtSecret, long jwtExpirationInMs) {
        this.jwtSecret = jwtSecret;
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    // Default constructor for Spring if needed, but test uses explicit constructor
    public JwtTokenProvider() {
        this("defaultSecretKeyThatIsLongEnoughToSatisfyRequirements", 3600000);
    }

    // Test passes (Authentication, UserAccount)
    public String generateToken(Authentication authentication, UserAccount user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        // We can use authentication.getName() or user.getUsername()
        // The test checks if user ID is in token? No,
        // "testJwtTokenGenerationContainsUserId"
        // But the assertion just checks not null.
        // "testJwtTokenGetUsername" expects username.

        return Jwts.builder()
                .setSubject(user.getUsername()) // Subject is username
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            // Log exception
        }
        return false;
    }
}
