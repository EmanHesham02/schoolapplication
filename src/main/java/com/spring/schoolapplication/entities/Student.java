package com.spring.schoolapplication.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student extends Person {

    @Column(name = "level")
    private int level = 1;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<Register> registrations;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Set<Register> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Register> registrations) {
        this.registrations = registrations;
    }
}