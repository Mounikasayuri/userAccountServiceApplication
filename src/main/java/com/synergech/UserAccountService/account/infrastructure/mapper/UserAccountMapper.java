package com.synergech.UserAccountService.account.infrastructure.mapper;

import com.synergech.UserAccountService.account.contracts.input.UserAccountRequestDTO;
import com.synergech.UserAccountService.account.domain.model.UserAccount;
import com.synergech.UserAccountService.users.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserAccountMapper {

    public UserAccount userAccountDetails(UserAccountRequestDTO userAccountRequestDTO) {

        UserAccount user = new UserAccount();
        User userData = new User();
        userData.setUserId(userAccountRequestDTO.getUserId());
        user.setUser(userData);
        user.setAccountNumber(userAccountRequestDTO.getAccountNumber());
        user.setAccountType(userAccountRequestDTO.getAccountType());
        user.setIfscCode(userAccountRequestDTO.getIfscCode());
        user.setBranch(userAccountRequestDTO.getBranch());
        user.setMobileNumber(userAccountRequestDTO.getMobileNumber());
        user.setEmail(userAccountRequestDTO.getEmail());
        user.setPanCard(userAccountRequestDTO.getPanCard());
        user.getOutgoingTransactions();
        return user;

    }
}
