package com.gustionusamba.bookcatalog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustionusamba.bookcatalog.security.util.JWTTokenFactory;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Key;

@Configuration
public class AppConfig {

    @Bean
    public Key key() {
        byte[] keyBytes = Decoders.BASE64.decode("qwertyuiop113333555555lkjhgfdsa9878767zmxncbv5581479612309640936123");
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Bean
    public JWTTokenFactory jwtTokenFactory(Key secret) {
        return new JWTTokenFactory(secret);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
