package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {

    Course findCourseById(Long courseId);

    @Override
    List<Course> findAll();
}
