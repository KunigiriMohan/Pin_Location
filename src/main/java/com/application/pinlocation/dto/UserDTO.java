package com.application.pinlocation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "User first name is Invalid")
    private String firstName;

    @Pattern (regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "User last name is Invalid")
    private String lastName;

    @Pattern(regexp = "^[6-9]{1}[0-9]{9,}$", message = "Phone Number is invalid")
    @NotNull(message = "Phone Number can not be null")
    private String mobileNo;

    @Pattern(regexp = "^[a-zA-Z0-9_+/#$%?~.-]+@[a-zA-Z0-9.-]+$", message = "Email is invalid")
    @NotNull(message = "Email should not empty")
    private String emailAddress;

    @NotNull(message = "City name should not empty")
    private String city;

    @NotNull(message = "State name should not empty")
    private String state;

    @NotNull(message = "Password should be not null")
    private String password;

    private Long id;
}
