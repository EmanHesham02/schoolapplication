package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.repostories.CategoryRepo;
import com.spring.schoolapplication.repostories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public CourseDto getCourseById(Long courseId) {
        CourseDto courseDto = new CourseDto();
        CategoryDto categoryDto = new CategoryDto();
        Course course = courseRepo.findCourseById(courseId);
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

    public List<CourseDto> getallCources() {
        List<CourseDto> courseDtoList = new ArrayList<>();
        List<Course> courseList = courseRepo.findAll();
        for (Course course : courseList) {
            CourseDto courseDto = new CourseDto();

            //////////
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryName(course.getCategory().getCategoryName());
            categoryDto.setCourse(course.getCategory().getCourse());

            /////
            courseDto.setCode(course.getCode());
            courseDto.setHour(course.getHour());
            courseDto.setRegistrationSet(course.getRegistrations());
            courseDto.setInstructor(course.getInstructor());
            courseDto.setDescription(course.getDescription());
            courseDto.setCategory(categoryDto);
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }
}
