package com.spring.schoolapplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student extends Person {

    @Column(name = "level")
    private int level = 1;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<CourseRegistration> registrations;

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