package com.spring.schoolapplication.mapper;

import com.spring.schoolapplication.dto.AddressDto;
import com.spring.schoolapplication.entities.Address;

public class AddressMapper {

    public void mappingAddressEntityToAddressDto( Address address, AddressDto addressDto) {
        addressDto.setStreet(address.getStreet());
        addressDto.setApartmentNum(address.getApartmentNum());
        addressDto.setBuildingNum(address.getBuildingNum());
        addressDto.setCity(address.getCity());
    }
    public void mappingAddressDtoToAddressEntity(AddressDto addressDto, Address address) {
        address.setStreet(addressDto.getStreet());
        address.setApartmentNum(addressDto.getApartmentNum());
        address.setBuildingNum(addressDto.getBuildingNum());
        address.setCity(addressDto.getCity());
    }

}
