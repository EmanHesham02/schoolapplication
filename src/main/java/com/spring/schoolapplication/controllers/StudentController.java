package com.spring.schoolapplication.controllers;

import com.spring.schoolapplication.dto.StudentDto;
import com.spring.schoolapplication.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {

        StudentDto studentDto1 = studentService.createStudent(studentDto);
        return ResponseEntity.ok(studentDto1);

    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        return ResponseEntity.ok(studentDto);

    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentDto>> getAllStudent() {
        List<StudentDto> studentDto = studentService.getAllStudent();
        return ResponseEntity.ok(studentDto);
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable(value = "studentId") Long studentId) {
        try {
            studentService.deleteStudent(studentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

    }

    @PutMapping("/Student/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(value = "studentId") Long studentId ,
                                                    @RequestBody StudentDto studentDto){
        StudentDto studentDto1 =studentService.updateStudent(studentId,studentDto);

          return ResponseEntity.ok(studentDto);
    }

}
