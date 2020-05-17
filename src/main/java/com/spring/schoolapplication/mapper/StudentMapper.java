package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.AddressDto;
import com.spring.schoolapplication.dto.StudentDto;
import com.spring.schoolapplication.entities.Address;
import com.spring.schoolapplication.entities.Student;

public class StudentMapper {
    AddressMapper addressMapper =new AddressMapper();

    public void mapStudentDtoToStudentEntity(Student student, StudentDto studentDto) {
        student.setName(studentDto.getName());
        student.setBirthDate(studentDto.getBirthDate());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setLevel(studentDto.getLevel());
        student.setRegistrations(studentDto.getRegistrations());
    }

    public void mapStudentEntityToStudentDto(Student student, StudentDto studentDto) {
        AddressDto addressDto = new AddressDto();
        addressMapper.mappingAddressEntityToAddressDto(student.getAddress(),addressDto);
        studentDto.setName(student.getName());
        studentDto.setBirthDate(student.getBirthDate());
        studentDto.setLevel(student.getLevel());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setAddress(addressDto);
        studentDto.setRegistrations(student.getRegistrations());
    }
}
