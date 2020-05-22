package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.RegisterDto;
import com.spring.schoolapplication.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api")
public class RegisterController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register/{studentId}/{courseId}")
    public ResponseEntity<RegisterDto> register(@PathVariable(value = "studentId") Long studentId,
                                                @PathVariable(value = "courseId") Long courseId) {
        RegisterDto registerDto = registrationService.register(studentId, courseId);
        return ResponseEntity.ok(registerDto);
    }


    @PutMapping("/register/{registerId}")
    public ResponseEntity<RegisterDto> updateRegister(@RequestBody RegisterDto registerDto) {
        RegisterDto registerDto1 = registrationService.updateregister(registerDto);
        return ResponseEntity.ok(registerDto1);
    }

    @PutMapping("/submitGrade")
    public ResponseEntity<RegisterDto> submitGrade(@RequestBody RegisterDto registerDto) {
        RegisterDto registerDto1 = registrationService.submitGrade(registerDto);
        return ResponseEntity.ok(registerDto1);
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
