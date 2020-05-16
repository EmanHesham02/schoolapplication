package com.spring.schoolapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.schoolapplication.entities.Course;

import java.io.Serializable;
import java.util.List;

public class CategoryDto implements Serializable {

    private Long id;

    private String categoryName;

    @JsonIgnore
    private List<Course> course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
