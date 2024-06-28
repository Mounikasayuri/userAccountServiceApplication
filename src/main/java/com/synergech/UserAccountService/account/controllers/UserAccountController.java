package com.synergech.UserAccountService.account.controllers;

import com.synergech.UserAccountService.account.applications.services.UserAccountServiceImpl;
import com.synergech.UserAccountService.account.contracts.input.UserAccountRequestDTO;
import com.synergech.UserAccountService.shared.exceptions.BadRequestException;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/account")
public class UserAccountController {

    @Autowired
    private UserAccountServiceImpl userAccountService;

    @GetMapping("/getAll")
    public ResponseEntity<BaseResponse> getAllUserAccount() {
        return userAccountService.getAllUserAccounts();
    }

    @GetMapping("/accountNumber/{accountNumber}")
    public ResponseEntity<BaseResponse> getUserAccountByAccountNumber(@PathVariable("accountNumber") Long accountNumber) {
        return userAccountService.getUserAccountByAccountNumber(accountNumber);
    }


    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createUserAccount(@Valid @RequestBody UserAccountRequestDTO user) throws BadRequestException {
        return userAccountService.createUserAccount(user);
    }

    @PutMapping("/update/{accountNumber}")
    public ResponseEntity<BaseResponse> updateUserAccount(@PathVariable long accountNumber, @Valid @RequestBody UserAccountRequestDTO user) {
        return this.userAccountService.editUserAccount(accountNumber, user);
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<BaseResponse> deleteUserAccount(@PathVariable long accountNumber) {
        return userAccountService.deleteUserAccountById(accountNumber);
    }

}


