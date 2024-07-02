package com.synergech.UserAccountService.transaction.contracts.input;

import com.synergech.UserAccountService.transaction.domain.enums.TransactionStatus;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.Date;


@Data
@Validated
public class TransactionFilterDTO {

    private Long fromAccountNumber;

    private Long toAccountId;

    private Timestamp fromDate;

    private Timestamp ToDate;

    private double amount;

    private String status;

}

