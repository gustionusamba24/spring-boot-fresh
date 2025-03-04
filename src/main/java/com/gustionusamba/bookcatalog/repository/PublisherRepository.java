package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Optional<Publisher> findBySecureId(String secureId);
}
