package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.AddressDto;
import com.spring.schoolapplication.dto.InstructorDto;
import com.spring.schoolapplication.entities.Address;
import com.spring.schoolapplication.entities.Instructor;

public class InstructorMapper {
    public void mapInstructorDtoToInstructortEntity(Instructor instructor, InstructorDto instructorDto) {
        instructor.setName(instructorDto.getName());
        instructor.setBirthDate(instructorDto.getBirthDate());
        instructor.setPhoneNumber(instructorDto.getPhoneNumber());
        instructor.setDegree(instructorDto.getDegree());
        instructor.setInstructorFaculty(instructorDto.getInstructorFaculty());
    }

    public void mapAddressFromInstructoDtoToAddressEntity(Address address, InstructorDto instructorDto) {
        address.setStreet(instructorDto.getAddressDto().getStreet());
        address.setApartmentNum(instructorDto.getAddressDto().getApartmentNum());
        address.setBuildingNum(instructorDto.getAddressDto().getBuildingNum());
        address.setCity(instructorDto.getAddressDto().getCity());
    }

    public void mapInstructorEntityToInstructorDto(Instructor instructor, InstructorDto instructorDto) {

        AddressDto addressDto = new AddressDto();
        mapAddressFromInstructorEntityToAddressDto(addressDto, instructor);
        instructorDto.setName(instructor.getName());
        instructorDto.setBirthDate(instructor.getBirthDate());
        instructorDto.setDegree(instructor.getDegree());
        instructorDto.setPhoneNumber(instructor.getPhoneNumber());
        instructorDto.setAddressDto(addressDto);
        instructorDto.setInstructorFaculty(instructor.getInstructorFaculty());
    }

    public void mapAddressFromInstructorEntityToAddressDto(AddressDto addressDto, Instructor instructor) {
        addressDto.setStreet(instructor.getAddress().getStreet());
        addressDto.setApartmentNum(instructor.getAddress().getApartmentNum());
        addressDto.setBuildingNum(instructor.getAddress().getBuildingNum());
        addressDto.setCity(instructor.getAddress().getCity());
    }

    public void mapAddressFromInstructorDtoToAddressEntity(Address address, InstructorDto instructorDto) {
        address.setStreet(instructorDto.getAddressDto().getStreet());
        address.setApartmentNum(instructorDto.getAddressDto().getApartmentNum());
        address.setBuildingNum(instructorDto.getAddressDto().getBuildingNum());
        address.setCity(instructorDto.getAddressDto().getCity());
    }
}
