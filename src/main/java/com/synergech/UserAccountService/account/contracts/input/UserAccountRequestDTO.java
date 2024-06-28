package com.synergech.UserAccountService.account.contracts.input;

import com.synergech.UserAccountService.account.domain.enums.AccountType;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.*;

@Data
@Validated
public class UserAccountRequestDTO {

    private long userId;

    @NotNull(message = "Account number is mandatory")
    @Min(value = 10, message = "Account number must be least 10 years")
    private long accountNumber;

    private AccountType accountType;

    @NotBlank(message = "IFSC code is mandatory")
    private String ifscCode;

    @NotBlank(message = "Branch is mandatory")
    private String branch;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
    private String mobileNumber;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Pan card number is mandatory")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN card format")
    private String panCard;
}
