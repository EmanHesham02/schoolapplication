package com.spring.schoolapplication.controllers;


import com.spring.schoolapplication.dto.CourseRegisterDto;
import com.spring.schoolapplication.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api")
public class StudentRegisterController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register/{studentId}/{courseId}")
    public ResponseEntity<CourseRegisterDto> register(@PathVariable(value = "studentId") Long studentId,
                                                      @PathVariable(value = "courseId") Long courseId) {
        CourseRegisterDto courseRegisterDto = registrationService.register(studentId, courseId);
        return ResponseEntity.ok(courseRegisterDto);
    }


    @PutMapping("/register/{registerId}")
    public ResponseEntity<CourseRegisterDto> updateRegister(@RequestBody CourseRegisterDto courseRegisterDto) {
        CourseRegisterDto courseRegisterDto1 = registrationService.updateregister(courseRegisterDto);
        return ResponseEntity.ok(courseRegisterDto1);
    }

    @PutMapping("/submitGrade/{registerId}")
    public ResponseEntity<CourseRegisterDto> submitGrade(@RequestBody CourseRegisterDto courseRegisterDto) {
        CourseRegisterDto courseRegisterDto1 = registrationService.submitGrade(courseRegisterDto);
        return ResponseEntity.ok(courseRegisterDto1);
    }


    @DeleteMapping("/unRegister/{registerId}")
    public ResponseEntity unRegister(@PathVariable(value = "registerId") Long registerId) {
        try {
            registrationService.unRegister(registerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

    }
}
