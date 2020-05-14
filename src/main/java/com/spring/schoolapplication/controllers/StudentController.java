package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api")
public class StudentController {


    @PostMapping("/student")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentData) {

        System.out.println(studentData);
        return null;

    }

}
