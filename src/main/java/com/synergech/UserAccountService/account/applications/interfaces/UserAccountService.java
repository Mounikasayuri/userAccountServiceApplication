package com.synergech.UserAccountService.account.applications.interfaces;

import com.synergech.UserAccountService.account.contracts.input.UserAccountRequestDTO;
import com.synergech.UserAccountService.shared.exceptions.BadRequestException;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountService {

    public ResponseEntity<BaseResponse> getAllUserAccounts();

    public ResponseEntity<BaseResponse> getUserAccountByAccountNumber(Long id);

    public ResponseEntity<BaseResponse> createUserAccount(UserAccountRequestDTO user) throws BadRequestException;

    public ResponseEntity<BaseResponse> editUserAccount(long id, UserAccountRequestDTO user);

    public ResponseEntity<BaseResponse> deleteUserAccountById(Long id);
}
