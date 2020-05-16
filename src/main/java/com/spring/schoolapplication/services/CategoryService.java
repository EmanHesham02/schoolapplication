package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.mapper.CategoryMapper;
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
            categoryMapper.mappingCategoryEntityToCategoryDto(categoryDto, category);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        categoryMapper.mappingCtegoryDtoToCategoryEntity(category, categoryDto);
        categoryRepo.save(category);
        categoryDto.setId(category.getId());
        return categoryDto;
    }

    public void deleteCategoryById(Long catedoryId) throws Exception {
        Optional<Category> category = categoryRepo.findById(catedoryId);
        if (category.isPresent()) {
            categoryRepo.deleteById(catedoryId);
        }else throw new Exception("not found");
    }

    public CategoryDto updateCategory(Long catedoryId, CategoryDto categoryDto) {
        Category category = categoryRepo.findCategoryById(catedoryId);
        categoryMapper.mappingCtegoryDtoToCategoryEntity(category, categoryDto);
        categoryRepo.save(category);
        return categoryDto;

    }
}
