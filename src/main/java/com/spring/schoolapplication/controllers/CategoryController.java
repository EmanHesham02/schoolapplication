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


    @PostMapping("category")
    public ResponseEntity<Object> createCategory(@RequestBody CategoryDto categoryDto) {
        return null;

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
}
