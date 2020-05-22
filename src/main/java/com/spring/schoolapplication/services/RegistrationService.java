package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.RegisterDto;
import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.entities.Register;
import com.spring.schoolapplication.entities.Student;
import com.spring.schoolapplication.enums.StatusType;
import com.spring.schoolapplication.mapper.RegistrationMapper;
import com.spring.schoolapplication.repostories.CourseRepo;
import com.spring.schoolapplication.repostories.RegistrationRepo;
import com.spring.schoolapplication.repostories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
public class RegistrationService {
    @Autowired
    RegistrationRepo registrationRepo;
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    CourseRepo courseRepo;
    RegistrationMapper registrationMapper = new RegistrationMapper();

    public RegisterDto register(Long studentId, Long courseId) {
        Student student = studentRepo.findStudentByPersonId(studentId);
        Course course = courseRepo.findCourseById(courseId);
        Register register = new Register();
        register.setCourse(course);
        register.setStudent(student);
        register.setRegisteredAt(LocalDateTime.now());
        registrationRepo.save(register);
        RegisterDto registerDto = new RegisterDto();
        registerDto.setStudentId(studentId);
        registerDto.setCourseId(courseId);
        return registerDto;

    }


    public void unRegister(Long registerId) throws Exception {
        Optional<Register> courseRegistration = registrationRepo.findById(registerId);
        if (courseRegistration.isPresent()) {
            registrationRepo.delete(courseRegistration.get());
        } else throw new Exception("not fount");

    }

    public RegisterDto updateregister(RegisterDto registerDto) {
        Course course = courseRepo.findCourseById(registerDto.getCourseId());
        Student student = studentRepo.findStudentByPersonId(registerDto.getStudentId());
        Register register = registrationRepo.findRegisterById(registerDto.getId());
        register.setStudent(student);
        register.setCourse(course);
        registrationRepo.save(register);
        return registerDto;
    }

    public RegisterDto submitGrade(RegisterDto registerDto) {
        Register register = registrationRepo.findRegisterById(registerDto.getId());
        register.setGrade(registerDto.getGrade());
        checkIfStudentPassCourse(register, registerDto);
        checkifStudentPassAllCoursesOfLevel(registerDto);
        registrationRepo.save(register);
        return registerDto;
    }

    private void checkIfStudentPassCourse(Register register, RegisterDto registerDto) {
        Course course = courseRepo.findCourseById(registerDto.getCourseId());
        if (registerDto.getGrade() >= course.getPassDegree()) {
            register.setStatus(StatusType.PASSED.getValue());
            registerDto.setStatus(StatusType.PASSED.getValue());
        } else {
            register.setStatus(StatusType.FAILD.getValue());
            registerDto.setStatus(StatusType.FAILD.getValue());
        }
    }

    private void checkifStudentPassAllCoursesOfLevel(RegisterDto registerDto) {
        Student student = studentRepo.findStudentByPersonId(registerDto.getStudentId());
        Set<Register> registrationList = student.getRegistrations();
        int coursePasses = 0;
        for (Register registration : registrationList) {
            if (registration.getStatus() == 0) {
                break;
            } else {
                coursePasses++;
            }
        }
        if (coursePasses == registrationList.size()) {
            student.setLevel(student.getLevel() + 1);
            studentRepo.save(student);
        }
    }
}
