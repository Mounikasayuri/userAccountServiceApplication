package com.synergech.UserAccountService.transaction.domain.repository;

import com.synergech.UserAccountService.transaction.constants.QueryConstants;
import com.synergech.UserAccountService.transaction.contracts.output.UserDetailsResultSet;
import com.synergech.UserAccountService.transaction.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = QueryConstants.TRANSACTION_DETAILS_QUERY, nativeQuery = true)
    List<UserDetailsResultSet> getTransactionDetails(@Param("status") String status,
                                                     @Param("accountNumber") Long accountNumber,
                                                     @Param("fromDate") String fromDate,
                                                     @Param("toDate") String toDate);
}




