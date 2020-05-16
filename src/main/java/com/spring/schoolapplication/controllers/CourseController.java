package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto courseDto) {
        CourseDto courseDto1 = courseService.createCourse(courseDto);
        return ResponseEntity.ok(courseDto1);
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

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable(value = "courseId") Long courseId) {
        try {
            courseService.deleteCourse(courseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/course/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable(value = "courseId") Long courseId, @RequestBody CourseDto courseDto) {
        CourseDto courseDto1 = courseService.updateCourse(courseId,courseDto);
        return ResponseEntity.ok(courseDto1);
    }
}
