package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.entities.Course;

public class CourseMapper {
    public void mappingCourseEntityToCourseDto(CourseDto courseDto, Course course) {
        CategoryDto categoryDto = new CategoryDto();
        mapCategoryDtoFromCourseEntity(categoryDto,course);
        courseDto.setCode(course.getCode());
        courseDto.setDescription(course.getDescription());
        courseDto.setHour(course.getHour());
        courseDto.setCategory(categoryDto);
        courseDto.setInstructor(course.getInstructor());
        courseDto.setRegistrationSet(course.getRegistrations());
    }

    public void mapCategoryDtoFromCourseEntity(CategoryDto categoryDto, Course course) {
        categoryDto.setCategoryName(course.getCategory().getCategoryName());
        categoryDto.setCourse(course.getCategory().getCourse());
    }

    public void mappingCourseDtoToCourseEntity(Course course, CourseDto courseDto) {
        course.setCode(courseDto.getCode());
        course.setHour(courseDto.getHour());
        course.setDescription(courseDto.getDescription());
        course.setInstructor(courseDto.getInstructor());
        course.setRegistrations(courseDto.getRegistrationSet());
    }
}
