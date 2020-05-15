package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.entities.Category;

public class CategoryMapper {

    public CategoryDto mappingCategoryEntityToCategoryDto(CategoryDto categoryDto, Category category) {
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }


    public Category mappingCtegoryDtoToCategoryEntity(Category category, CategoryDto categoryDto) {
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }
}
