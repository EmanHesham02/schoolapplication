package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.CategoryDto;
import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.mapper.CourseMapper;
import com.spring.schoolapplication.repostories.CategoryRepo;
import com.spring.schoolapplication.repostories.CourseRepo;
import com.spring.schoolapplication.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;
    private CourseMapper courseMapper = new CourseMapper();

    public CourseDto getCourseById(Long courseId) {
        CourseDto courseDto = new CourseDto();
        Course course = courseRepo.findCourseById(courseId);
        courseMapper.mappingCourseEntityToCourseDto(courseDto, course);
        return courseDto;
    }

    public List<CourseDto> getallCources() {
        List<CourseDto> courseDtoList = new ArrayList<>();
        List<Course> courseList = courseRepo.findAll();
        for (Course course : courseList) {
            CourseDto courseDto = new CourseDto();
            courseMapper.mappingCourseEntityToCourseDto(courseDto, course);
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }

    public ResponseEntity createCourse(CourseDto courseDto) {
        Course course = new Course();
        courseMapper.mappingCourseDtoToCourseEntity(course, courseDto);
        courseRepo.save(course);
        return CommonUtils.getSuccessResponse();
    }

    public ResponseEntity deleteCourse(Long courseId) {
        Optional<Course> course = courseRepo.findById(courseId);
        if (course.isPresent()) {
            courseRepo.deleteById(courseId);
            return CommonUtils.getSuccessResponse();
        }
        return ResponseEntity.notFound().build();
    }
}
