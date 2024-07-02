package com.synergech.UserAccountService.transaction.controllers;

import com.synergech.UserAccountService.shared.exceptions.BadRequestException;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import com.synergech.UserAccountService.transaction.applications.services.TransactionServiceImpl;
import com.synergech.UserAccountService.transaction.contracts.input.TransactionFilterRequestDTO;
import com.synergech.UserAccountService.transaction.contracts.input.TransactionRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createUserAccount(@Valid @RequestBody TransactionRequestDTO transactionRequestDTO) throws BadRequestException {
        return transactionService.createTransaction(transactionRequestDTO);
    }

    @PostMapping("/filter")
    public ResponseEntity<BaseResponse> transactionFilterResponse(@Valid @RequestBody TransactionFilterRequestDTO transactionFilterDTO) throws BadRequestException {
        return transactionService.searchTransaction(transactionFilterDTO);
    }
}

