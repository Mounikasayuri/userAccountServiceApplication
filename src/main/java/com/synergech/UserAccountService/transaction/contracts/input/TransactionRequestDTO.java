package com.synergech.UserAccountService.transaction.contracts.input;

import com.synergech.UserAccountService.transaction.domain.enums.TransactionStatus;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Data
@Validated
@Getter
@ToString
public class TransactionRequestDTO {

    private long fromAccountNumber;

    private long toAccountId;

    private Date transDateTime;

    private double amount;

    private TransactionStatus status;

}
