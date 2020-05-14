package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {


    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody String studentData) {
        return null;

    }

}
