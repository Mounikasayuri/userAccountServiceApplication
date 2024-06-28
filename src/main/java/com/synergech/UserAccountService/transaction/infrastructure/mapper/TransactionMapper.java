package com.synergech.UserAccountService.transaction.infrastructure.mapper;

import com.synergech.UserAccountService.account.contracts.input.UserAccountRequestDTO;
import com.synergech.UserAccountService.account.domain.model.UserAccount;
import com.synergech.UserAccountService.transaction.contracts.input.TransactionRequestDTO;
import com.synergech.UserAccountService.transaction.domain.model.Transaction;
import com.synergech.UserAccountService.users.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {


    public Transaction transactionDetails(TransactionRequestDTO transactionRequestDTO) {

        UserAccount userAccount = new UserAccount();
        userAccount.setAccountNumber(transactionRequestDTO.getFromAccountNumber());
        Transaction transaction = new Transaction();
        transaction.setUserAccount(userAccount);
        transaction.setFromAccountNumber(transactionRequestDTO.getFromAccountNumber());
        transaction.setToAccountId(transactionRequestDTO.getToAccountId());
        transaction.setTransDateTime(transactionRequestDTO.getTransDateTime());
        transaction.setAmount(transactionRequestDTO.getAmount());
        transaction.setStatus(transactionRequestDTO.getStatus());
        return transaction;

    }
}
