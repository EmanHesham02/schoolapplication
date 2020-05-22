package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.entities.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Register, Long> {

    Register findRegisterById(Long id);

}
