package com.bridgelabz.addressbookspring.service;

import com.bridgelabz.addressbookspring.dto.AddressDto;
import com.bridgelabz.addressbookspring.entity.AddressEntity;
import com.bridgelabz.addressbookspring.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<AddressEntity> getAllAddressBook() {
        return addressRepository.findAll();
    }

    public String addAddressBook(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity(addressDto);
        // addressEntity = modelMapper.map(addressDto, AddressEntity.class);
        addressRepository.save(addressEntity);
        return "Address Book is added Successfully";
    }

    public String updateAddressBook(int id, AddressDto addressDto) {
        Optional<AddressEntity> addressEntityOptional = addressRepository.findById(id);
        if (addressEntityOptional.isPresent()){
            AddressEntity addressEntity = addressEntityOptional.get();
            addressEntity.setAddress(addressDto.getAddress());
            addressEntity.setName(addressDto.getName());
            addressEntity.setCity(addressDto.getCity());
            addressEntity.setZip(addressDto.getZip());
            addressEntity.setState(addressDto.getState());
            addressEntity.setPhoneNumber(addressDto.getPhoneNumber());
            addressEntity.setLandmark(addressDto.getLandmark());
            addressRepository.save(addressEntity);
            return "Address Book is Updated Successfully";
        }
        return "Address Book ID is not found";
    }

    public String deleteAddressBook(int id) {
        Optional<AddressEntity>addressEntityOptional =addressRepository.findById(id);
        if(addressEntityOptional.isPresent()){
            addressRepository.delete(addressEntityOptional.get());
            return "Address Book is Deleted Successfully";
        }
        return "Address Book ID is not found";
    }
}
