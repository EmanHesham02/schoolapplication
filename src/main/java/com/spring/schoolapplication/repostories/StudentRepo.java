package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.entities.Course;
import com.spring.schoolapplication.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Student findStudentByPersonId(Long studentId);

//    @Override
//    List<Student> findAll();
}
