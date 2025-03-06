package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.domain.Category;
import com.gustionusamba.bookcatalog.dto.CategoryCreateUpdateDTO;
import com.gustionusamba.bookcatalog.repository.CategoryRepository;
import com.gustionusamba.bookcatalog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createAndUpdateCategory(CategoryCreateUpdateDTO dto) {
        Category category = categoryRepository.findByCode(dto.getCode().toLowerCase()).orElse(new Category());
        if (category.getCode() == null) {
            category.setCode(dto.getCode().toLowerCase()); // new
        }
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        categoryRepository.save(category);
    }
}
