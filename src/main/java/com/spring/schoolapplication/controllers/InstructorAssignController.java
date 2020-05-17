package com.spring.schoolapplication.controllers;


import com.spring.schoolapplication.dto.CourseDto;
import com.spring.schoolapplication.services.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Api")
public class InstructorAssignController {
    @Autowired
    AssignService assignService;

    @PutMapping("/courseAssign/{courseId}/{instructorId}")
    public ResponseEntity<CourseDto> instructorAssign(@PathVariable(value = "courseId") Long courseId,
                                                      @PathVariable(value = "instructorId") Long instructorId) {
        CourseDto courseDto = assignService.assignInstructorToCourse(courseId, instructorId);

        return ResponseEntity.ok(courseDto);
    }
    @PutMapping("/courseUnAssign/{courseId}/{instructorId}")
    public ResponseEntity<CourseDto> instructorUnAssign(@PathVariable(value = "courseId") Long courseId) {
        CourseDto courseDto = assignService.unassignInstructorFromCourse(courseId);

        return ResponseEntity.ok(courseDto);
    }
}
