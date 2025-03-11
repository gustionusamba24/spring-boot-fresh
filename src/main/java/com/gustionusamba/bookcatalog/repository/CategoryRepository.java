package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByCode(String code);

    Page<Category> findByNameLikeIgnoreCase(String categoryName, Pageable pageable);

    List<Category> findByCodeIn(List<String> codes);
}
