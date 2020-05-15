package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.entities.Course;

public class CourseMapper {
    public CourseDto mappingCourseEntityToCourseDto(CourseDto courseDto, Course course) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(course.getCategory().getCategoryName());
        categoryDto.setCourse(course.getCategory().getCourse());

        courseDto.setCode(course.getCode());
        courseDto.setDescription(course.getDescription());
        courseDto.setHour(course.getHour());
        courseDto.setCategory(categoryDto);
        courseDto.setInstructor(course.getInstructor());
        courseDto.setRegistrationSet(course.getRegistrations());
        return courseDto;
    }

    public Course mappingCourseDtoToCourseEntity(Course course, CourseDto courseDto) {
        Category category = new Category();
        category.setCategoryName(courseDto.getCategory().getCategoryName());
        category.setCourse(courseDto.getCategory().getCourse());
        course.setCode(courseDto.getCode());
        course.setHour(courseDto.getHour());
        course.setDescription(courseDto.getDescription());
        course.setInstructor(courseDto.getInstructor());
        course.setRegistrations(courseDto.getRegistrationSet());
        course.setCategory(category);
        return course;
    }
}
