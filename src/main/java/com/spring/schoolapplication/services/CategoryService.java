package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.repostories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryDto getCategoryById(Long catedoryId) {
        CategoryDto categoryDto = new CategoryDto();
        Category category = categoryRepo.findCategoryById(catedoryId);
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }

    public List<CategoryDto> getallCategory() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> categoryList = categoryRepo.findAll();
        for (Category category : categoryList) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryName(category.getCategoryName());
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }
}
