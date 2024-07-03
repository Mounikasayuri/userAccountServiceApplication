package com.synergech.UserAccountService.transaction.contracts.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatementResponseDTO {

    private List<TransactionFilterResponseDTO> transactions;

    private String accountNumber;

    private String accountHolderName;

    private String accountType;

    private String branchName;

    private String ifscCode;

    private String address;

    private String fromDate;

    private String toDate;

}
