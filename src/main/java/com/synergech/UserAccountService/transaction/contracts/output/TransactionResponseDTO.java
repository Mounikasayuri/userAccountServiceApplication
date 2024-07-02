package com.synergech.UserAccountService.transaction.contracts.output;

import com.synergech.UserAccountService.transaction.domain.enums.TransactionStatus;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionResponseDTO {

    private long transId;

    private long fromAccountNumber;

    private long toAccountId;

    private Date transDateTime;

    private double amount;

    private TransactionStatus status;

}
