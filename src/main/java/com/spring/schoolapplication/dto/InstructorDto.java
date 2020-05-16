package com.spring.schoolapplication.dto;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class InstructorDto implements Serializable {


    private String name;
    private AddressDto addressDto;
    private Date birthDate;
    private String phoneNumber;
    private String instructorFaculty;
    private String degree;

    private List<CourseDto> courseDtos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstructorFaculty() {
        return instructorFaculty;
    }

    public void setInstructorFaculty(String instructorFaculty) {
        this.instructorFaculty = instructorFaculty;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<CourseDto> getCourseDtos() {
        return courseDtos;
    }

    public void setCourseDtos(List<CourseDto> courseDtos) {
        this.courseDtos = courseDtos;
    }

}
