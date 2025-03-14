package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findById(Long id);

    List<Author> findBySecureIdIn(List<String> authorIdList);

    Optional<Author> findBySecureId(String id);

    List<Author> findByNameLike(String authorName);

    Optional<Author> findByIdAndDeletedFalse(Long id);
}
