package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.entities.Instructor;
import com.spring.schoolapplication.mapper.CourseMapper;
import com.spring.schoolapplication.repostories.CourseRepo;
import com.spring.schoolapplication.repostories.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignService {

    @Autowired
    CourseRepo courseRepo;
    @Autowired
    InstructorRepo instructorRepo;
    CourseMapper courseMapper = new CourseMapper();

    public CourseDto assignInstructorToCourse(Long courseId, Long instructorId) {
        Course course = courseRepo.findCourseById(courseId);
        Instructor instructor = instructorRepo.findInstructorByPersonId(instructorId);
        course.setInstructor(instructor);
        List<Course> courseList = instructor.getCourse();
        courseList.add(course);
        instructor.setCourse(courseList);
        courseRepo.save(course);
        instructorRepo.save(instructor);
        CourseDto courseDto = new CourseDto();
        courseMapper.mappingCourseEntityToCourseDto(course, courseDto);
        return courseDto;
    }

    public CourseDto unassignInstructorFromCourse(Long courseId) {
        Course course = courseRepo.findCourseById(courseId);
        Instructor instructor = instructorRepo.findInstructorByPersonId(course.getInstructor().getPersonId());
        course.setInstructor(null);
        courseRepo.save(course);
        List<Course> courseList = instructor.getCourse();
        courseList.remove(course);
        instructorRepo.save(instructor);
        CourseDto courseDto = new CourseDto();
        courseMapper.mappingCourseEntityToCourseDto(course, courseDto);
        return courseDto;
    }
}
