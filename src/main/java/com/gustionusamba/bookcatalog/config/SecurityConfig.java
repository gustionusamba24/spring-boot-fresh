package com.gustionusamba.bookcatalog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustionusamba.bookcatalog.filter.UsernamePasswordAuthProcessingFilter;
import com.gustionusamba.bookcatalog.security.handler.UsernamePasswordAuthFailureHandler;
import com.gustionusamba.bookcatalog.security.handler.UsernamePasswordAuthSuccessHandler;
import com.gustionusamba.bookcatalog.security.provider.UsernamePasswordAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private final static String AUTH_URL = "/v1/login";

    @Autowired
    private UsernamePasswordAuthProvider usernamePasswordAuthProvider;

    @Bean
    public AuthenticationSuccessHandler usernamePasswordAuthSuccessHandler(ObjectMapper objectMapper) {
        return new UsernamePasswordAuthSuccessHandler(objectMapper);
    }

    @Bean
    public AuthenticationFailureHandler usernamePasswordAuthFailureHandler(ObjectMapper objectMapper) {
        return new UsernamePasswordAuthFailureHandler(objectMapper);
    }

    @Autowired
    void registerProvider(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(usernamePasswordAuthProvider);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public UsernamePasswordAuthProcessingFilter usernamePasswordAuthProcessingFilter(ObjectMapper objectMapper, AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, AuthenticationManager authenticationManager) {
        UsernamePasswordAuthProcessingFilter filter = new UsernamePasswordAuthProcessingFilter(AUTH_URL, objectMapper, successHandler, failureHandler);
        filter.setAuthenticationManager(authenticationManager);
        return filter;
    }


//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests((authz) ->
//                        authz.anyRequest().authenticated())
//                .csrf((csrf) -> csrf.disable())
//                .sessionManagement(sessionManagementCustomizer -> sessionManagementCustomizer
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .httpBasic(Customizer.withDefaults())
//                .build();
//    }
}
