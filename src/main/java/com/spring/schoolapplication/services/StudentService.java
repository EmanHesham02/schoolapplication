package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.StudentDto;
import com.spring.schoolapplication.entities.Address;
import com.spring.schoolapplication.entities.Student;
import com.spring.schoolapplication.mapper.StudentMapper;
import com.spring.schoolapplication.repostories.AddressRepo;
import com.spring.schoolapplication.repostories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    StudentMapper studentMapper = new StudentMapper();

    public StudentDto createStudent(StudentDto studentDto) {
        Student student = new Student();
        Address address = new Address();
        studentMapper.mapStudentDtoToStudentEntity(student, studentDto);
        studentMapper.mapAddressFromStudentDtoToAddressEntity(address, studentDto);
        student.setAddress(address);
        studentRepo.save(student);
        return studentDto;

    }

    public StudentDto getStudentById(Long studentId) {
        StudentDto studentDto = new StudentDto();
        Student student = studentRepo.findStudentByPersonId(studentId);
        studentMapper.mapStudentEntityToStudentDto(student, studentDto);
        return studentDto;
    }

    public List<StudentDto> getAllStudent() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> studentList = studentRepo.findAll();
        for (Student student : studentList) {
            StudentDto studentDto = new StudentDto();
            studentMapper.mapStudentEntityToStudentDto(student, studentDto);
            studentDtoList.add(studentDto);
        }
        return studentDtoList;

    }

    public void deleteStudent(Long studentId) throws Exception {
        Optional<Student> student = studentRepo.findById(studentId);
        if (student.isPresent()) {
            studentRepo.deleteById(studentId);
        } else throw new Exception("not found");
    }

    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        Student student = studentRepo.findStudentByPersonId(studentId);
        Address address = student.getAddress();
        studentMapper.mapAddressFromStudentDtoToAddressEntity(address, studentDto);
        studentMapper.mapStudentDtoToStudentEntity(student, studentDto);
        student.setAddress(address);
        studentRepo.save(student);
        return studentDto;
    }
}
