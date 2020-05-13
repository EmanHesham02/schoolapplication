package com.spring.schoolapplication.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends Person {

    @Column(name = "level")
    private int level;

    @OneToMany(mappedBy = "student")
    private Set<CourseRegistration> registrations;

//
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//            name = "Student_course",
//            joinColumns = {@JoinColumn(name = "employee_id")},
//            inverseJoinColumns = {@JoinColumn(name = "project_id")}
//    )
//    Set<Course> courses = new HashSet<>();



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Set<CourseRegistration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<CourseRegistration> registrations) {
        this.registrations = registrations;
    }
}