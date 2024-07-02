package com.synergech.UserAccountService.transaction.applications.interfaces;

import com.synergech.UserAccountService.shared.exceptions.BadRequestException;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import com.synergech.UserAccountService.transaction.contracts.input.TransactionFilterDTO;
import com.synergech.UserAccountService.transaction.contracts.input.TransactionRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    public ResponseEntity<BaseResponse> createTransaction(TransactionRequestDTO user) throws BadRequestException;

    public ResponseEntity<BaseResponse> searchTransaction(TransactionFilterDTO user) throws BadRequestException;

}
