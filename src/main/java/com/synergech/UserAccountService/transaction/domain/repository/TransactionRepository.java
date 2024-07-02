package com.synergech.UserAccountService.transaction.domain.repository;

import com.synergech.UserAccountService.transaction.contracts.output.TransactionResponseDTO;
import com.synergech.UserAccountService.transaction.contracts.output.UserDetailsRequestDTO;
import com.synergech.UserAccountService.transaction.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import static com.synergech.UserAccountService.transaction.constants.QueryConstants.TRANSACTION_DETAILS;
import static com.synergech.UserAccountService.transaction.constants.QueryConstants.USER_ACCOUNT_DETAILS;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = USER_ACCOUNT_DETAILS,nativeQuery = true)
    public List<UserDetailsRequestDTO> getUserByAccountNumber(@Param("accountNumber") Long accountNumber);

    @Query(value = TRANSACTION_DETAILS,nativeQuery = true)
    public List<Transaction> getTransactionData(@Param("status") String status,
                                                @Param("accountNumber") Long accountNumber,
                                                @Param("fromDate") Date fromDate,
                                                @Param("toDate") Date toDate);

//    @Query("SELECT t FROM Transaction t WHERE t.fromAccountNumber = :accountNumber OR t.toAccountId = :accountNumber")
//    List<Transaction> findByAccountNumber(@Param("accountNumber") long accountNumber);


}




