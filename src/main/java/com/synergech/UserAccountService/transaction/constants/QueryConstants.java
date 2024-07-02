package com.synergech.UserAccountService.transaction.constants;

public class QueryConstants {
    public static final String TRANSACTION_DETAILS_QUERY = """
            select userData.user_name accountHolderName,
            userData.address address,
            userAcc.account_number accountNumber,
            userAcc.ifsc_code ifscCode,
            userAcc.branch branchName,
            userAcc.account_type accountType,
            transactionData.amount amount,
            transactionData.to_account_id toAccountId,
            transactionData.trans_id transId,
            transactionData.from_account_number fromAccountNumber,
            transactionData.status status,
            transactionData.trans_date_time transDateTime
            from user_account.user_account_data As userAcc
            Left join user_account.user_data As userData
            on userData.user_id = userAcc.user_id
            Left join user_account.transaction_data As transactionData
            on transactionData.account_number = userAcc.account_number
            where transactionData.trans_date_time BETWEEN cast(:fromDate as TIMESTAMP) AND cast(:toDate as TIMESTAMP)
            AND transactionData.status  ILIKE '%'||:status||'%'
            AND (transactionData.from_account_number = :accountNumber
                   OR transactionData.to_account_id = :accountNumber);""";

}

