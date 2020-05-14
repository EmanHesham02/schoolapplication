package com.spring.schoolapplication.dto;

import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.entities.CourseRegistration;
import com.spring.schoolapplication.entities.Instructor;

import java.io.Serializable;
import java.util.Set;

public class CourseDto implements Serializable {

    private String code;
    private Integer hour;
    private String description;
    private CategoryDto category;
    private Set<CourseRegistration> registrationSet;
    private Instructor instructor;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public Set<CourseRegistration> getRegistrationSet() {
        return registrationSet;
    }

    public void setRegistrationSet(Set<CourseRegistration> registrationSet) {
        this.registrationSet = registrationSet;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
