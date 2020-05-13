package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
