package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.CategoryCreateUpdateDTO;
import com.gustionusamba.bookcatalog.dto.CategoryListResponseDTO;
import com.gustionusamba.bookcatalog.dto.ResultPageResponseDTO;

public interface CategoryService {

    void createAndUpdateCategory(CategoryCreateUpdateDTO dto);

    ResultPageResponseDTO<CategoryListResponseDTO> getCategories(Integer pages, Integer limit, String sortBy,
                                                                 String direction, String categoryName);
}
