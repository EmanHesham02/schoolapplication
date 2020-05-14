package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Api")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("course")
    public ResponseEntity<Object> createCategory(@RequestBody CourseDto categoryDto) {
        return null;

    }

    @GetMapping("/course/{courseId}")
    public CourseDto getCourse(@PathVariable Long courseId) {
        CourseDto courseDto;
        courseDto = courseService.getCourseById(courseId);
        return courseDto;
    }

    @GetMapping("/course")
    public List<CourseDto> getAllCourses() {
        List<CourseDto> courseDto;
        courseDto = courseService.getallCources();
        return courseDto;
    }
}
