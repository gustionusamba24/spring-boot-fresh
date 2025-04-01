package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.domain.Category;
import com.gustionusamba.bookcatalog.dto.CategoryCreateUpdateDTO;
import com.gustionusamba.bookcatalog.dto.CategoryListResponseDTO;
import com.gustionusamba.bookcatalog.dto.CategoryQueryDTO;
import com.gustionusamba.bookcatalog.dto.ResultPageResponseDTO;
import com.gustionusamba.bookcatalog.exception.BadRequestException;
import com.gustionusamba.bookcatalog.repository.CategoryRepository;
import com.gustionusamba.bookcatalog.service.CategoryService;
import com.gustionusamba.bookcatalog.util.PaginationUtil;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public ResultPageResponseDTO<CategoryListResponseDTO> getCategories(Integer pages, Integer limit, String sortBy,
                                                                        String direction, String categoryName) {
        categoryName = StringUtils.isBlank(categoryName) ? "%" : categoryName + "%";
        Sort sort = Sort.by(new Sort.Order(PaginationUtil.getSortBy(direction), sortBy));
        Pageable pageable = PageRequest.of(pages, limit, sort);
        Page<Category> pageResult = categoryRepository.findByNameLikeIgnoreCase(categoryName, pageable);
        List<CategoryListResponseDTO> dtos = pageResult.stream().map((c) -> {
            CategoryListResponseDTO dto = new CategoryListResponseDTO();
            dto.setCode(c.getCode());
            dto.setName(c.getName());
            dto.setDescription(c.getDescription());
            return dto;
        }).collect(Collectors.toList());
        return PaginationUtil.createResultPageDTO(dtos, pageResult.getTotalElements(), pageResult.getTotalPages());
    }

    @Override
    public List<Category> findCategories(List<String> categoryCodeList) {
        List<Category> categories = categoryRepository.findByCodeIn(categoryCodeList);
        if (categories.isEmpty()) throw new BadRequestException("category can not be empty");
        return categories;
    }

    @Override
    public List<CategoryListResponseDTO> constructDTO(List<Category> categories) {
        return categories.stream().map((c) -> {
            CategoryListResponseDTO dto = new CategoryListResponseDTO();
            dto.setCode(c.getCode());
            dto.setName(c.getName());
            dto.setDescription(c.getDescription());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Map<Long, List<String>> findCategoriesMap(List<Long> bookIdList) {
        List<CategoryQueryDTO> queryList = categoryRepository.findCategoryByBookIdList(bookIdList);
        Map<Long, List<String>> categoryMaps = new HashMap<>();
        List<String> categoryCodeList;
        for (CategoryQueryDTO q : queryList) {
            if (!categoryMaps.containsKey(q.getBookId())) {
                categoryCodeList = new ArrayList<>();
            } else {
                categoryCodeList = categoryMaps.get(q.getBookId());
            }
            categoryCodeList.add(q.getCategoryCode());
            categoryMaps.put(q.getBookId(), categoryCodeList);
        }
        return categoryMaps;
    }
}
