package com.spring.schoolapplication.services;

import com.spring.schoolapplication.dto.CourseRegisterDto;
import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.entities.CourseRegistration;
import com.spring.schoolapplication.entities.Student;
import com.spring.schoolapplication.enums.StatusType;
import com.spring.schoolapplication.mapper.RegistrationMapper;
import com.spring.schoolapplication.repostories.CourseRepo;
import com.spring.schoolapplication.repostories.RegistrationRepo;
import com.spring.schoolapplication.repostories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    public CourseRegisterDto register(Long studentId, Long courseId) {
        Student student = studentRepo.findStudentByPersonId(studentId);
        Course course = courseRepo.findCourseById(courseId);
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourse(course);
        courseRegistration.setStudent(student);
        courseRegistration.setRegisteredAt(LocalDateTime.now());
        registrationRepo.save(courseRegistration);
        CourseRegisterDto courseRegisterDto = new CourseRegisterDto();
        courseRegisterDto.setStudentDtoId(studentId);
        courseRegisterDto.setCourseDtoId(courseId);
        return courseRegisterDto;

    }


    public void unRegister(Long registerId) throws Exception {
        Optional<CourseRegistration> courseRegistration = registrationRepo.findById(registerId);
        if (courseRegistration.isPresent()) {
            registrationRepo.delete(courseRegistration.get());
        } else throw new Exception("not fount");

    }

    public CourseRegisterDto updateregister(CourseRegisterDto courseRegistrationDto) {
        Course course = courseRepo.findCourseById(courseRegistrationDto.getCourseDtoId());
        Student student = studentRepo.findStudentByPersonId(courseRegistrationDto.getStudentDtoId());
        CourseRegistration courseRegistration = registrationRepo.findCourseRegistrationById(courseRegistrationDto.getId());
        courseRegistration.setStudent(student);
        courseRegistration.setCourse(course);
        registrationRepo.save(courseRegistration);
        return courseRegistrationDto;
    }

    public CourseRegisterDto submitGrade(CourseRegisterDto courseRegisterDto) {
        CourseRegistration courseRegistration = registrationRepo.findCourseRegistrationById(courseRegisterDto.getId());
        courseRegistration.setGrade(courseRegisterDto.getGrade());
        checkIfStudentPassCourse(courseRegistration, courseRegisterDto);
        checkifStudentPassAllCoursesOfLevel(courseRegisterDto);
        return courseRegisterDto;
    }

    private void checkIfStudentPassCourse(CourseRegistration courseRegistration, CourseRegisterDto courseRegistrationDto) {
        if (courseRegistrationDto.getGrade() >= 50) {
            courseRegistration.setStatus(StatusType.PASSED.getValue());
            courseRegistrationDto.setStatus(StatusType.PASSED.getValue());
        } else {
            courseRegistration.setStatus(StatusType.FAILD.getValue());
            courseRegistrationDto.setStatus(StatusType.FAILD.getValue());
        }
    }

    private void checkifStudentPassAllCoursesOfLevel(CourseRegisterDto courseRegisterDto) {
        Student student = studentRepo.findStudentByPersonId(courseRegisterDto.getStudentDtoId());
        Set<CourseRegistration> registrationList = student.getRegistrations();
        int coursePasses = 0;
        for (CourseRegistration registration : registrationList) {
            if (registration.getStatus() == 1) {
                coursePasses++;
                if (coursePasses == registrationList.size()) {
                    student.setLevel(student.getLevel() + 1);
                    studentRepo.save(student);
                }
            }

        }
    }
}
