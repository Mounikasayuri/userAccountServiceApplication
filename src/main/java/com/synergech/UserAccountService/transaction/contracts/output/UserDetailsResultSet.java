package com.synergech.UserAccountService.transaction.contracts.output;

import com.synergech.UserAccountService.transaction.domain.enums.TransactionStatus;

public interface UserDetailsResultSet {

    String getAccountNumber();

    String getAccountHolderName();

    String getAccountType();

    String getBranchName();

    String getIfscCode();

    String getAddress();

    Long getTransId();

    Long getFromAccountNumber();

   Long getToAccountId();

    String getTransDateTime();

    Double getAmount();

    TransactionStatus getStatus();

}
