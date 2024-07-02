package com.synergech.UserAccountService.transaction.constants;

public class QueryConstants {

    public static final String USER_ACCOUNT_DETAILS = """
            select  userData.user_name,userData.address,userAcc.account_number,userAcc.ifsc_code,userAcc.branch,
            userAcc.account_type from user_account.user_account_data as userAcc
            Left join user_account.user_data As userData
            on userData.user_id = userAcc.user_id where userAcc.account_number = :accountNumber""";

    public static final String TRANSACTION_DETAILS = """
            SELECT *
            FROM user_account.transaction_data AS transaction                        
            WHERE transaction.trans_date_time BETWEEN cast(:fromDate as TIMESTAMP) AND cast(:toDate as TIMESTAMP)
             AND transaction.status LIKE :status
              AND (transaction.from_account_number = :accountNumber
                   OR transaction.to_account_id = :accountNumber);""";

}

