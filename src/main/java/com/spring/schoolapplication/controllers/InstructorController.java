package com.spring.schoolapplication.controllers;


import com.spring.schoolapplication.dto.InstructorDto;
import com.spring.schoolapplication.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/Api")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @PostMapping("/instructor")
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto instructorDto) {
        InstructorDto instructorDto1 = instructorService.createInstructor(instructorDto);
        return ResponseEntity.created(URI.create("/instructor/" + instructorDto1)).build();
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<InstructorDto> getInstructor(@PathVariable Long instructorId) {
        InstructorDto instructorDto = instructorService.getInstructorById(instructorId);
        return ResponseEntity.ok(instructorDto);

    }

    @GetMapping("/instructor")
    public ResponseEntity<List<InstructorDto>> getAllInstructor() {
        List<InstructorDto> instructorDto = instructorService.getAllInstructor();
        return ResponseEntity.ok(instructorDto);
    }

    @DeleteMapping("/instructor/{instructorId}")
    public ResponseEntity deleteInstructor(@PathVariable(value = "instructorId") Long instructorId) {
        try {
            instructorService.deleteInstructor(instructorId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

    }

    @PutMapping("/instructor/{instructorId}")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable(value = "instructorId") Long instructorId,
                                                    @RequestBody InstructorDto instructorDto) {
        InstructorDto instructorDto1 = instructorService.updateInstructor(instructorId, instructorDto);

        return ResponseEntity.ok(instructorDto);
    }

}
