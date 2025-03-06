package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByCode(String code);
}
