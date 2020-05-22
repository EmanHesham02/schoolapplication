package com.spring.schoolapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.schoolapplication.entities.Register;
import com.spring.schoolapplication.entities.Instructor;

import java.io.Serializable;
import java.util.Set;

public class CourseDto implements Serializable {

    private Long id;

    private String code;

    private Integer hour;

    private String description;

    private CategoryDto category;
    @JsonIgnore
    private Set<Register> registrationSet;
    @JsonIgnore
    private Instructor instructor;

    private Integer level;

    private Integer passDegree;


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

    public Set<Register> getRegistrationSet() {
        return registrationSet;
    }

    public void setRegistrationSet(Set<Register> registrationSet) {
        this.registrationSet = registrationSet;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPassDegree() {
        return passDegree;
    }

    public void setPassDegree(Integer passDegree) {
        this.passDegree = passDegree;
    }
}
