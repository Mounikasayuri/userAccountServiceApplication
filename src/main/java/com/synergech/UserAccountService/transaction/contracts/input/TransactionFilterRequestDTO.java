package com.synergech.UserAccountService.transaction.contracts.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Getter
@Setter
@ToString
public class TransactionFilterRequestDTO {

    private Long fromAccountNumber;

    private Long toAccountId;

    private String fromDate;

    private String ToDate;

    private double amount;

    private String status;

}

