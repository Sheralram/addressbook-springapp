package com.bridgelabz.addressbookspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Name is Invalid")
    private String name;

    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "City is Invalid")
    private String city;

    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "State is Invalid")
    private String state;

    @Pattern(regexp = "^[0-9]{2,}$", message = "Zip is Invalid")
    private String zip;

    @Pattern(regexp = "^[0-9]{2,}$", message = "PhoneNumber is Invalid")
    private String phoneNumber;

    private String address;

    private String landmark;

    private String type;


}
