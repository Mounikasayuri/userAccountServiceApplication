package com.synergech.UserAccountService.account.domain.repository;

import com.synergech.UserAccountService.account.domain.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {

     UserAccount findByAccountNumber(Long accountNumber);
     void deleteByAccountNumber(Long accountNumber);

}
