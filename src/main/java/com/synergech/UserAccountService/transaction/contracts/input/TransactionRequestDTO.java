package com.synergech.UserAccountService.transaction.contracts.input;

import com.synergech.UserAccountService.transaction.domain.enums.TransactionStatus;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;
import java.sql.Timestamp;

@Data
@Validated
@Getter
@ToString
public class TransactionRequestDTO {

    private long fromAccountNumber;

    private long toAccountId;

    private Timestamp transDateTime;

    private double amount;

    private TransactionStatus status;

}
