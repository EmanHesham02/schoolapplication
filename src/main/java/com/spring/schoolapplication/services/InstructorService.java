package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.InstructorDto;
import com.spring.schoolapplication.entities.Address;
import com.spring.schoolapplication.entities.Instructor;
import com.spring.schoolapplication.mapper.AddressMapper;
import com.spring.schoolapplication.mapper.InstructorMapper;
import com.spring.schoolapplication.repostories.AddressRepo;
import com.spring.schoolapplication.repostories.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    InstructorRepo instructorRepo;

    InstructorMapper instructorMapper = new InstructorMapper();

    AddressMapper addressMapper =new AddressMapper();

    public InstructorDto createInstructor(InstructorDto instructorDto) {
        Instructor instructor = new Instructor();
        Address address = new Address();
        addressMapper.mappingAddressDtoToAddressEntity(instructorDto.getAddressDto(),address);
        instructor.setAddress(address);
        instructorMapper.mapInstructorDtoToInstructortEntity(instructor, instructorDto);
        instructorRepo.save(instructor);
        return instructorDto;
    }

    public InstructorDto getInstructorById(Long instructorId) {

        InstructorDto instructorDto = new InstructorDto();
        Instructor instructor = instructorRepo.findInstructorByPersonId(instructorId);
        instructorMapper.mapInstructorEntityToInstructorDto(instructor, instructorDto);
        return instructorDto;

    }

    public List<InstructorDto> getAllInstructor() {
        List<InstructorDto> instructorDtoList = new ArrayList<>();
        List<Instructor> instructorList = instructorRepo.findAll();
        for (Instructor instructor : instructorList) {
            InstructorDto instructorDto = new InstructorDto();
            instructorMapper.mapInstructorEntityToInstructorDto(instructor, instructorDto);
            instructorDtoList.add(instructorDto);
        }
        return instructorDtoList;
    }

    public void deleteInstructor(Long instructorId) throws Exception {
        Optional<Instructor> student = instructorRepo.findById(instructorId);
        if (student.isPresent()) {
            instructorRepo.deleteById(instructorId);
        } else throw new Exception("not found");
    }

    public InstructorDto updateInstructor(Long instructorId, InstructorDto instructorDto) {
        Instructor instructor = instructorRepo.findInstructorByPersonId(instructorId);
        Address address =instructor.getAddress();
        addressMapper.mappingAddressDtoToAddressEntity(instructorDto.getAddressDto(),address);
        instructorMapper.mapInstructorDtoToInstructortEntity(instructor, instructorDto);
        instructor.setAddress(address);
        instructorRepo.save(instructor);
        return instructorDto;
    }
}
