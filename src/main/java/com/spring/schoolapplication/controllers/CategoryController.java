package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        CategoryDto categoryDto1 = categoryService.createCategory(categoryDto);
        return ResponseEntity.ok(categoryDto1);
    }

    @GetMapping("/category/{catedoryId}")
    public ResponseEntity<CategoryDto> getGategory(@PathVariable Long catedoryId) {
        CategoryDto categoryDto;
        categoryDto = categoryService.getCategoryById(catedoryId);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getGategory() {
        List<CategoryDto> categoryDto;
        categoryDto = categoryService.getallCategory();
        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable(value = "categoryId") Long catedoryId) {
        try {
            categoryService.deleteCategoryById(catedoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable(value = "categoryId") Long catedoryId,
                                                      @RequestBody CategoryDto categoryDto) {
        CategoryDto categoryDto1 = categoryService.updateCategory(catedoryId, categoryDto);
        return ResponseEntity.ok(categoryDto1);
    }
}
