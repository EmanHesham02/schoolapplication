package com.spring.schoolapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CourseRegisterDto implements Serializable {

    private Long id;
    private Long studentDtoId;
    private Long courseDtoId;
    @JsonIgnore
    private LocalDateTime registeredAt;
    private Long grade;
    @JsonIgnore
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentDtoId() {
        return studentDtoId;
    }

    public void setStudentDtoId(Long studentDtoId) {
        this.studentDtoId = studentDtoId;
    }

    public Long getCourseDtoId() {
        return courseDtoId;
    }

    public void setCourseDtoId(Long courseDtoId) {
        this.courseDtoId = courseDtoId;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
