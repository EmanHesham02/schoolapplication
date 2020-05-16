package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.entities.Category;

public class CategoryMapper {

    public void mappingCategoryEntityToCategoryDto(CategoryDto categoryDto, Category category) {
        categoryDto.setId(category.getId());
        categoryDto.setCategoryName(category.getCategoryName());
    }


    public void mappingCtegoryDtoToCategoryEntity(Category category, CategoryDto categoryDto) {
        categoryDto.setId(category.getId());
        category.setCategoryName(categoryDto.getCategoryName());
    }
}
