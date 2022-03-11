package com.bridgelabz.addressbookspring.entity;

import com.bridgelabz.addressbookspring.dto.AddressDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP")
    private String zip;

    private String phoneNumber;

    private String address;

    private String landmark;



    public AddressEntity(AddressDto addressDto) {
        this.name = addressDto.getName();
        this.city = addressDto.getCity();
        this.state = addressDto.getState();
        this.zip = addressDto.getZip();
    }

    public AddressEntity(){

    }
}
