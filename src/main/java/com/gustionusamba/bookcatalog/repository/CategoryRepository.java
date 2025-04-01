package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Category;
import com.gustionusamba.bookcatalog.dto.CategoryQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByCode(String code);

    Page<Category> findByNameLikeIgnoreCase(String categoryName, Pageable pageable);

    List<Category> findByCodeIn(List<String> codes);

    @Query("SELECT new com.gustionusamba.bookcatalog.dto.CategoryQueryDTO(b.id, bc.code) " +
            "FROM Book b " +
            "JOIN b.categories bc " +
            "WHERE b.id IN :bookIdList")
    List<CategoryQueryDTO> findCategoryByBookIdList(List<Long> bookIdList);
}
