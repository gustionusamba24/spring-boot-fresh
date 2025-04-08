package com.gustionusamba.bookcatalog.security.util;

import com.gustionusamba.bookcatalog.security.model.AccessJWTToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JWTTokenFactory {

    private final Key secret;

    public AccessJWTToken createAccessJWTToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Claims claims = Jwts.claims()
                .subject(username)
                .add("scope", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())).build();

        // kapan waktu token dibuat
        LocalDateTime currentTime = LocalDateTime.now();
        Date currentTimeDate = Date.from(currentTime.atZone(ZoneId.of("Asia/Jakarta")).toInstant());

        // kapan waktu token expired
        LocalDateTime expiredTime = currentTime.plusMinutes(15);
        Date expiredTimeDate = Date.from(expiredTime.atZone(ZoneId.of("Asia/Jakarta")).toInstant());

        // issuer
        String token = Jwts.builder().claims(claims)
                .issuer("https://www.linkedin.com/in/gustio-nusamba/")
                .issuedAt(currentTimeDate)
                .expiration(expiredTimeDate)
                .signWith(secret).compact();

        return new AccessJWTToken(token, claims);
    }
}
