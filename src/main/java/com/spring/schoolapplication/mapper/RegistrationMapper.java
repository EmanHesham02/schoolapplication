package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.dto.StudentDto;
import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.entities.Student;

public class RegistrationMapper {
    StudentMapper studentMapper = new StudentMapper();
    CourseMapper courseMapper = new CourseMapper();
    public void mappingCoureAndAstudentEntityToCourseAndStudentDto
            (Course course, Student student, CourseDto courseDto, StudentDto studentDto) {
        studentMapper.mapStudentEntityToStudentDto(student, studentDto);
        courseMapper.mappingCourseEntityToCourseDto(course, courseDto);
    }

    public void mappincoureDtoAndStudentDtoToCourseEntityAndRegistrationEntity
            (CourseDto courseDto, StudentDto studentDto, Course course, Student student) {
        studentMapper.mapStudentDtoToStudentEntity(student,studentDto);
        courseMapper.mappingCourseDtoToCourseEntity(courseDto,course);
    }
}
