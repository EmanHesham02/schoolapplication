package com.spring.schoolapplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Instructor extends Person {

    @Column(name = "instructor_faculty")
    private String instructorFaculty;

    @Column(name = "ins_degree")
    private String degree;


    @OneToMany(mappedBy = "instructor")
    private List<Course> course;


    public String getInstructorFaculty() {
        return instructorFaculty;
    }

    public void setInstructorFaculty(String instructorFaculty) {
        this.instructorFaculty = instructorFaculty;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
