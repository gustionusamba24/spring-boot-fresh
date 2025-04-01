package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.dto.AuthorQueryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findById(Long id);

    List<Author> findBySecureIdIn(List<String> authorIdList);

    Optional<Author> findBySecureId(String id);

    List<Author> findByNameLike(String authorName);

    Optional<Author> findByIdAndDeletedFalse(Long id);


    @Query("SELECT new com.gustionusamba.bookcatalog.dto.AuthorQueryDTO(b.id, ba.name) " +
            "FROM Book b " +
            "JOIN b.authors ba " +
            "WHERE b.id IN :bookIdList")
    List<AuthorQueryDTO> findAuthorByBookIdList(List<Long> bookIdList);
}
