package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.dto.CategoryCreateUpdateDTO;
import com.gustionusamba.bookcatalog.dto.CategoryListResponseDTO;
import com.gustionusamba.bookcatalog.dto.ResultPageResponseDTO;
import com.gustionusamba.bookcatalog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
public class CategoryResource {

    private final CategoryService categoryService;

    @PostMapping("/v1/category")
    public ResponseEntity<Void> createAndUpdateCategory(@RequestBody CategoryCreateUpdateDTO dto) {
        categoryService.createAndUpdateCategory(dto);
        return ResponseEntity.created(URI.create("/v1/category")).build();
    }

    @GetMapping("/v1/category")
    public ResponseEntity<ResultPageResponseDTO<CategoryListResponseDTO>> getCategories(@RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages,
                                                                                        @RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
                                                                                        @RequestParam(name = "sortBy", required = true, defaultValue = "name") String sortBy,
                                                                                        @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
                                                                                        @RequestParam(name = "categoryName", required = false) String categoryName) {
        return ResponseEntity.ok().body(categoryService.getCategories(pages, limit, sortBy, direction, categoryName));
    }
}
