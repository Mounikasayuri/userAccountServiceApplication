package com.synergech.UserAccountService.transaction.domain.repository;

import com.synergech.UserAccountService.transaction.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
