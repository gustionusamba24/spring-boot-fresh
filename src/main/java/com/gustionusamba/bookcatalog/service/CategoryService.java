package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.domain.Category;
import com.gustionusamba.bookcatalog.dto.CategoryCreateUpdateDTO;
import com.gustionusamba.bookcatalog.dto.CategoryListResponseDTO;
import com.gustionusamba.bookcatalog.dto.ResultPageResponseDTO;

import java.util.List;

public interface CategoryService {

    void createAndUpdateCategory(CategoryCreateUpdateDTO dto);

    ResultPageResponseDTO<CategoryListResponseDTO> getCategories(Integer pages, Integer limit, String sortBy,
                                                                 String direction, String categoryName);

    List<Category> findCategories(List<String> categoryCodeList);
}
