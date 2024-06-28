package com.synergech.UserAccountService.account.contracts.output;

import com.synergech.UserAccountService.account.domain.enums.AccountType;
import lombok.Data;

@Data
public class UserAccountResponseDTO {

    private long userId;

    private long accountNumber;

    private AccountType accountType;

    private String ifscCode;

    private String branch;

    private String mobileNumber;

    private String email;

    private String panCard;

}
