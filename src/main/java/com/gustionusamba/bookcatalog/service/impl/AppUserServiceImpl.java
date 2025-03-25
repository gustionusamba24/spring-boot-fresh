package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.dto.UserDetailResponseDTO;
import com.gustionusamba.bookcatalog.exception.ResourceNotFoundException;
import com.gustionusamba.bookcatalog.repository.AppUserRepository;
import com.gustionusamba.bookcatalog.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("invalid username"));
    }

    @Override
    public UserDetailResponseDTO findUserDetail() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        UserDetailResponseDTO dto = new UserDetailResponseDTO();
        String username = ctx.getAuthentication().getName();
        dto.setUsername(username);
        return dto;
    }
}
