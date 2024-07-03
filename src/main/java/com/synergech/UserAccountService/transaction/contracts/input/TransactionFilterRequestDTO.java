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

    private Long accountNumber;

    private String fromDate;

    private String ToDate;

    private String status;

}

