package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.AddressDto;
import com.spring.schoolapplication.dto.StudentDto;
import com.spring.schoolapplication.entities.Address;
import com.spring.schoolapplication.entities.Student;

public class StudentMapper {
    public void mapStudentDtoToStudentEntity(Student student, StudentDto studentDto) {
        student.setName(studentDto.getName());
        student.setBirthDate(studentDto.getBirthDate());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setLevel(studentDto.getLevel());
        student.setRegistrations(studentDto.getRegistrations());
    }

    public void mapAddressFromStudentDtoToAddressEntity(Address address, StudentDto studentDto) {
        address.setStreet(studentDto.getAddress().getStreet());
        address.setApartmentNum(studentDto.getAddress().getApartmentNum());
        address.setBuildingNum(studentDto.getAddress().getBuildingNum());
        address.setCity(studentDto.getAddress().getCity());
    }

    public void mapAddressFromStudentEntityToAddressDto(AddressDto addressDto, Student student) {
        addressDto.setStreet(student.getAddress().getStreet());
        addressDto.setApartmentNum(student.getAddress().getApartmentNum());
        addressDto.setBuildingNum(student.getAddress().getBuildingNum());
        addressDto.setCity(student.getAddress().getCity());
    }


    public void mapStudentEntityToStudentDto(Student student, StudentDto studentDto) {
        AddressDto addressDto = new AddressDto();
        mapAddressFromStudentEntityToAddressDto(addressDto, student);
        studentDto.setName(student.getName());
        studentDto.setBirthDate(student.getBirthDate());
        studentDto.setLevel(student.getLevel());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setAddress(addressDto);
        studentDto.setRegistrations(student.getRegistrations());
    }
}
