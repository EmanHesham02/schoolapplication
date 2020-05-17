package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.entities.Course;

public class CourseMapper {
    public void mappingCourseEntityToCourseDto(Course course, CourseDto courseDto) {
        CategoryDto categoryDto = new CategoryDto();
        mapCategoryDtoFromCourseEntity(categoryDto, course);
        courseDto.setId(course.getId());
        courseDto.setCode(course.getCode());
        courseDto.setDescription(course.getDescription());
        courseDto.setHour(course.getHour());
        courseDto.setCategory(categoryDto);
        courseDto.setInstructor(course.getInstructor());
        courseDto.setRegistrationSet(course.getRegistrations());
    }

    public void mapCategoryDtoFromCourseEntity(CategoryDto categoryDto, Course course) {
        categoryDto.setId(course.getCategory().getId());
        categoryDto.setCategoryName(course.getCategory().getCategoryName());
        categoryDto.setCourse(course.getCategory().getCourse());
    }

    public void mappingCourseDtoToCourseEntity(CourseDto courseDto, Course course) {
        course.setCode(courseDto.getCode());
        course.setHour(courseDto.getHour());
        course.setDescription(courseDto.getDescription());
        course.setInstructor(courseDto.getInstructor());
        course.setRegistrations(courseDto.getRegistrationSet());
        course.setLevel(courseDto.getLevel());
    }
}
