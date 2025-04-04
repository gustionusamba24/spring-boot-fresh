package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.dto.UserDetailResponseDTO;
import com.gustionusamba.bookcatalog.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserResource {

    private final AppUserService appUserService;

    @GetMapping("/v1/user")
    public ResponseEntity<UserDetailResponseDTO> findUserDetail() {
        return ResponseEntity.ok(appUserService.findUserDetail());
    }
}
