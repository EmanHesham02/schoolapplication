package com.spring.schoolapplication.dto;

import java.io.Serializable;


public class StudentDto implements Serializable {

    private String name;
    private AddressDto address;
    private String birthDate;
    private String phoneNumber;
    private Integer level;
    private String registrations;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public String getRegistrations() {
        return registrations;
    }

    public void setRegistrations(String registrations) {
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
