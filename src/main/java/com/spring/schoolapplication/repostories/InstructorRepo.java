package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.dto.InstructorDto;
import com.spring.schoolapplication.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {

    Instructor findInstructorByPersonId(Long instructorId);

}
