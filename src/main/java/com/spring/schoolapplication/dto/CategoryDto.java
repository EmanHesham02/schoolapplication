package com.spring.schoolapplication.dto;

import com.spring.schoolapplication.entities.Course;

import java.io.Serializable;
import java.util.List;

public class CategoryDto implements Serializable {
    private String categoryName;

    private List<Course> course;

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
