package com.spring.schoolapplication.repostories;

import com.spring.schoolapplication.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {

    Address findAddressById(Long id);
}
