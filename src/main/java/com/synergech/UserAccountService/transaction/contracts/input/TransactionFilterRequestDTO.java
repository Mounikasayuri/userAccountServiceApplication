package com.synergech.UserAccountService.transaction.contracts.input;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFilterRequestDTO {

    private Long fromAccountNumber;

    private Long toAccountId;

    private String fromDate;

    private String ToDate;

    private double amount;

    private String status;

}

