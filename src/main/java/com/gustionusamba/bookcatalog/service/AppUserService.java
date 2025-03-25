package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.UserDetailResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {

    UserDetailResponseDTO findUserDetail();
}
