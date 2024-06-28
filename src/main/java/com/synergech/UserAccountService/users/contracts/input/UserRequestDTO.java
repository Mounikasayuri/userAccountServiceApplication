package com.synergech.UserAccountService.users.contracts.input;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Data
@Validated
public class UserRequestDTO {

    @NotBlank(message = "Username is mandatory")
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String userName;

    @Min(value = 18, message = "Age must be at least 18 years")
    @Max(value = 150, message = "Age cannot be more than 150 years")
    private int age;

    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Date of birth is mandatory")
    @Past(message = "Date of birth must be in the past")
    private Date dob;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Address shouldn't be null")
    private String address;

    @NotBlank(message = "Mobile number shouldn't be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits.")
    private String mobileNumber;
}
