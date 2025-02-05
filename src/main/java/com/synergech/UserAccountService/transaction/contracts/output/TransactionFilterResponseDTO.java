package com.synergech.UserAccountService.transaction.contracts.output;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.synergech.UserAccountService.transaction.domain.enums.TransactionStatus;
import lombok.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionFilterResponseDTO {

    private Long transId;

    private Long fromAccountNumber;

    private Long toAccountId;

    private String transDateTime;

    private double amount;

    private TransactionStatus status;

}
