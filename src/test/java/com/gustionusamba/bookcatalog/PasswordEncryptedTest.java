package com.gustionusamba.bookcatalog;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("default")
@Slf4j
public class PasswordEncryptedTest {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordEncryptedTest(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Test
    public void encryptPassword() {
        log.info("Encrypted password: {}", passwordEncoder.encode("password"));
    }
}
