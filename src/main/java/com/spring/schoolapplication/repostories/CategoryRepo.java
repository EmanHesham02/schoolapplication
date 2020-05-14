package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.entities.Category;
import com.spring.schoolapplication.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    Category findCategoryById(Long catedoryId);

    @Override
    List<Category> findAll();
}
