package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepo extends JpaRepository<Course, Long> {
}
