package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.entities.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<CourseRegistration, Long> {

    CourseRegistration findCourseRegistrationById(Long id);

}
