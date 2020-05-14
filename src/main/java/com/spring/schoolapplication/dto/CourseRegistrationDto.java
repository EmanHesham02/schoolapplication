package com.spring.schoolapplication.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CourseRegistrationDto implements Serializable {

    private StudentDto studentDto;
    private CourseDto course;
    private LocalDateTime registeredAt;
    private Integer grade;

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
