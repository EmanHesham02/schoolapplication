package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.AddressDto;
import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.dto.InstructorDto;
import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorMapper {

    AddressMapper addressMapper = new AddressMapper();
    CourseMapper courseMapper = new CourseMapper();

    public void mapInstructorDtoToInstructortEntity(Instructor instructor, InstructorDto instructorDto) {
        instructor.setName(instructorDto.getName());
        instructor.setBirthDate(instructorDto.getBirthDate());
        instructor.setPhoneNumber(instructorDto.getPhoneNumber());
        instructor.setDegree(instructorDto.getDegree());
        instructor.setInstructorFaculty(instructorDto.getInstructorFaculty());
    }


    public void mapInstructorEntityToInstructorDto(Instructor instructor, InstructorDto instructorDto) {
        AddressDto addressDto = new AddressDto();
        List<CourseDto> courseDtoList = new ArrayList<>();
        addressMapper.mappingAddressEntityToAddressDto(instructor.getAddress(), addressDto);
        instructorDto.setName(instructor.getName());
        instructorDto.setBirthDate(instructor.getBirthDate());
        instructorDto.setDegree(instructor.getDegree());
        instructorDto.setPhoneNumber(instructor.getPhoneNumber());
        instructorDto.setAddressDto(addressDto);
        instructorDto.setInstructorFaculty(instructor.getInstructorFaculty());
        mappingListOfCourseEntityToListOfCourseDto(courseDtoList, instructor.getCourse());
        instructorDto.setCourseDtos(courseDtoList);
    }

    public void mappingListOfCourseEntityToListOfCourseDto(List<CourseDto> courseDtoList, List<Course> courseList) {

        for (Course course : courseList) {
            CourseDto courseDto = new CourseDto();
            courseMapper.mappingCourseEntityToCourseDto(course, courseDto);
            courseDtoList.add(courseDto);
        }
    }


}
