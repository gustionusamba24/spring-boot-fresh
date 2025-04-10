package com.gustionusamba.bookcatalog.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustionusamba.bookcatalog.security.model.AccessJWTToken;
import com.gustionusamba.bookcatalog.security.util.JWTTokenFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UsernamePasswordAuthSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper;

    private JWTTokenFactory jwtTokenFactory;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AccessJWTToken token = jwtTokenFactory.createAccessJWTToken(userDetails.getUsername(), userDetails.getAuthorities());
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("token", token.getRawToken());
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        objectMapper.writeValue(response.getWriter(), resultMap);
    }
}
