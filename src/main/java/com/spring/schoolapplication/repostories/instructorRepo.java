package com.spring.schoolapplication.repostories;
import com.spring.schoolapplication.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface instructorRepo extends JpaRepository<Instructor, Long> {
}
