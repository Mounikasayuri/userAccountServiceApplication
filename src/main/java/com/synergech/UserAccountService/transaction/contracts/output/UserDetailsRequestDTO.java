package com.synergech.UserAccountService.transaction.contracts.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;


public interface UserDetailsRequestDTO {

    String getAccountNumber();

    String getAccountHolderName();

    String getAccountType();

    String getBranchName();

    String getIfscCode();

    String getAddress();

}
