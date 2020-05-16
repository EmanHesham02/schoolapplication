package com.spring.schoolapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.schoolapplication.entities.CourseRegistration;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class StudentDto implements Serializable {

    private String name;
    private AddressDto address;
    private Date birthDate;
    private String phoneNumber;
    private Integer level;
    @JsonIgnore
    private Set<CourseRegistration> registrations;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Set<CourseRegistration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<CourseRegistration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", birthDate='" + birthDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", level=" + level +
                ", registrations='" + registrations + '\'' +
                '}';
    }
}
