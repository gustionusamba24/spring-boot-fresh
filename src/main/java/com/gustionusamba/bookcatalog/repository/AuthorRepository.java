package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Override
    public Optional<Author> findById(Long id);

    public List<Author> findByNameLike(String authorName);
}
