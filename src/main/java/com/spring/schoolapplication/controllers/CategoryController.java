package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        ResponseEntity responseEntity = categoryService.createCategory(categoryDto);
        return responseEntity;
    }

    @GetMapping("/category/{catedoryId}")
    public CategoryDto getGategory(@PathVariable Long catedoryId) {
        CategoryDto categoryDto;
        categoryDto = categoryService.getCategoryById(catedoryId);
        return categoryDto;
    }

    @GetMapping("/category")
    public List<CategoryDto> getGategory() {
        List<CategoryDto> categoryDto;
        categoryDto = categoryService.getallCategory();
        return categoryDto;
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable(value = "categoryId") Long catedoryId) {
        ResponseEntity responseEntity = categoryService.deleteCategoryById(catedoryId);
        return responseEntity;

    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable(value = "categoryId") Long catedoryId,
                                                      @RequestBody CategoryDto categoryDto) {
        ResponseEntity responseEntity = categoryService.updateCategory(catedoryId, categoryDto);
        return responseEntity;
    }
}
