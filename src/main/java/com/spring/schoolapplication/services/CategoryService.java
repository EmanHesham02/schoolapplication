package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.mapper.CategoryMapper;
import com.spring.schoolapplication.repostories.CategoryRepo;
import com.spring.schoolapplication.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    private CategoryMapper categoryMapper = new CategoryMapper();

    public CategoryDto getCategoryById(Long catedoryId) {
        CategoryDto categoryDto = new CategoryDto();
        Category category = categoryRepo.findCategoryById(catedoryId);
        categoryMapper.mappingCategoryEntityToCategoryDto(categoryDto, category);
        return categoryDto;
    }

    public List<CategoryDto> getallCategory() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> categoryList = categoryRepo.findAll();
        for (Category category : categoryList) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto = categoryMapper.mappingCategoryEntityToCategoryDto(categoryDto, category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    public ResponseEntity createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        categoryMapper.mappingCtegoryDtoToCategoryEntity(category, categoryDto);
        categoryRepo.save(category);
        return CommonUtils.getSuccessResponse();
    }

    public ResponseEntity deleteCategoryById(Long catedoryId) {
        Optional<Category> category = categoryRepo.findById(catedoryId);
        if (category.isPresent()) {
            categoryRepo.deleteById(catedoryId);
            return CommonUtils.getSuccessResponse();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity updateCategory(Long catedoryId, CategoryDto categoryDto) {
        Category category = categoryRepo.findCategoryById(catedoryId);
        categoryMapper.mappingCtegoryDtoToCategoryEntity(category, categoryDto);
        categoryRepo.save(category);
        return CommonUtils.getSuccessResponse();

    }
}
