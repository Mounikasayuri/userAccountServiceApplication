package com.synergech.UserAccountService.account.domain.repository;

import com.synergech.UserAccountService.account.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {

     Optional<UserAccount> findByAccountNumber(Long accountNumber);
     void deleteByAccountNumber(Long accountNumber);

}
