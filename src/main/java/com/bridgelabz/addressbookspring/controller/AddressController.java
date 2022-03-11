package com.bridgelabz.addressbookspring.controller;

import com.bridgelabz.addressbookspring.dto.AddressDto;
import com.bridgelabz.addressbookspring.entity.AddressEntity;
import com.bridgelabz.addressbookspring.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(value = "/address-book")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value="/list-all-address")
    public List<AddressEntity> getAllAddressBook(){
        return addressService.getAllAddressBook();
    }

    @PostMapping(value = "/create")
    public String addAddressBook(@Valid @RequestBody AddressDto addressDto){
        return addressService.addAddressBook(addressDto);
    }

    @PutMapping(value= "/update/{id}")
    public String updateAddressBook(@PathVariable int id,@Valid @RequestBody AddressDto addressDto){
        return  addressService.updateAddressBook(id,addressDto);
    }


    @DeleteMapping(value = "/delete/{id}")
    public String deleteAddressBook(@Valid @PathVariable int id){
        return addressService.deleteAddressBook(id);
    }


}
