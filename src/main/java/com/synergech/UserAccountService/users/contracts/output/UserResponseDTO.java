package com.synergech.UserAccountService.users.contracts.output;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDTO {

    private long userId;

    private String userName;

    private int age;

    private String gender;

    private Date dob;

    private String email;

    private String address;

    private String mobileNumber;

}
