package com.gustionusamba.bookcatalog.config;

import com.gustionusamba.bookcatalog.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final AppUserService appUserService;

    @Autowired
    public SecurityConfig(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Autowired
    void registerProvider(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.userDetailsService(appUserService).passwordEncoder(passwordEncoder);
    }
}
