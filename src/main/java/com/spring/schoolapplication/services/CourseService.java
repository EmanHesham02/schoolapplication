package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.mapper.CourseMapper;
import com.spring.schoolapplication.repostories.CategoryRepo;
import com.spring.schoolapplication.repostories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    CategoryRepo categoryRepo;

    private CourseMapper courseMapper = new CourseMapper();

    public CourseDto getCourseById(Long courseId) {
        CourseDto courseDto = new CourseDto();
        Course course = courseRepo.findCourseById(courseId);
        courseMapper.mappingCourseEntityToCourseDto(course, courseDto);
        return courseDto;
    }

    public List<CourseDto> getallCources() {
        List<CourseDto> courseDtoList = new ArrayList<>();
        List<Course> courseList = courseRepo.findAll();
        for (Course course : courseList) {
            CourseDto courseDto = new CourseDto();
            courseMapper.mappingCourseEntityToCourseDto(course, courseDto);
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }

    public CourseDto createCourse(CourseDto courseDto) {
        Course course = new Course();
        Category category = categoryRepo.findCategoryById(courseDto.getCategory().getId());
        course.setCategory(category);
        courseMapper.mappingCourseDtoToCourseEntity(courseDto, course);
        courseRepo.save(course);
        return courseDto;
    }

    public void deleteCourse(Long courseId) throws Exception {
        Optional<Course> course = courseRepo.findById(courseId);
        if (course.isPresent()) {
            courseRepo.deleteById(courseId);
        } else throw new Exception("not found");
    }

    public CourseDto updateCourse(Long courseId, CourseDto courseDto) {
        Course course = courseRepo.findCourseById(courseId);
        courseMapper.mappingCourseDtoToCourseEntity(courseDto, course);
        courseRepo.save(course);
        return courseDto;
    }

}
