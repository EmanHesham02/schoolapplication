package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("create")
    public ResponseEntity<Object> createCategory(@RequestBody CourseDto categoryDto) {
        return null;

    }

    @GetMapping("/get/{courseId}")
    public CourseDto getGategory(@PathVariable Long courseId) {
        CourseDto courseDto;
        courseDto = courseService.getCourseById(courseId);
        return courseDto;
    }

    @GetMapping("/getall")
    public List<CourseDto> getGategory() {
        List<CourseDto> categoryDto;
        categoryDto = courseService.getallCources();
        return categoryDto;
    }
}
