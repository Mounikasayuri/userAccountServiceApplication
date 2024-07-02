package com.synergech.UserAccountService.transaction.applications.services;

import com.synergech.UserAccountService.account.domain.model.UserAccount;
import com.synergech.UserAccountService.account.domain.repository.UserAccountRepository;
import com.synergech.UserAccountService.shared.exceptions.BadRequestException;
import com.synergech.UserAccountService.shared.exceptions.NotFoundException;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import com.synergech.UserAccountService.transaction.applications.interfaces.TransactionService;
import com.synergech.UserAccountService.transaction.contracts.input.TransactionFilterDTO;
import com.synergech.UserAccountService.transaction.contracts.input.TransactionRequestDTO;
import com.synergech.UserAccountService.transaction.contracts.output.AccountStatementResponseDTO;
import com.synergech.UserAccountService.transaction.contracts.output.TransactionResponseDTO;
import com.synergech.UserAccountService.transaction.contracts.output.UserDetailsRequestDTO;
import com.synergech.UserAccountService.transaction.domain.model.Transaction;
import com.synergech.UserAccountService.transaction.domain.repository.TransactionRepository;
import com.synergech.UserAccountService.transaction.infrastructure.mapper.TransactionMapper;
import com.synergech.UserAccountService.users.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

import static com.synergech.UserAccountService.transaction.constants.MessageConstants.*;
import static com.synergech.UserAccountService.users.constants.MessageConstants.SUCCESS;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public ResponseEntity<BaseResponse> createTransaction(TransactionRequestDTO transactionRequestDTO) throws BadRequestException {

        log.info("Started");
        Transaction transaction = transactionMapper.transactionDetails(transactionRequestDTO);

        UserAccount userAccount = transaction.getUserAccount();
        long accountNumber = userAccount.getAccountNumber();

        if (!userAccountRepository.existsById(accountNumber)) {
            throw new NotFoundException(INVALID_ACCOUNT_NUMBER);
        }

        userAccountRepository.getReferenceById(transaction.getUserAccount().getAccountNumber());

        Transaction transactionData = transactionRepository.save(transaction);

        TransactionResponseDTO transactionResponseDTO = getTransactionResponseDTO(transactionData);
        return ResponseEntity.ok().body(BaseResponse.builder()
                .data(transactionResponseDTO)
                .message(TRANSACTION_CREATED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build());

    }

    @Override
    public ResponseEntity<BaseResponse> searchTransaction(TransactionFilterDTO transactionRequestDTO) throws BadRequestException {

        AccountStatementResponseDTO accountStatementResponseDTO = new AccountStatementResponseDTO();
        log.info("api started");
        List<UserDetailsRequestDTO> accountDetails = transactionRepository.getUserByAccountNumber(transactionRequestDTO.getFromAccountNumber());
        log.info("fetching details");
        if (accountDetails.isEmpty()) {
            throw new BadRequestException("Account details not found");
        }
        log.info("setting details");
        UserDetailsRequestDTO userDetails = accountDetails.get(0);
        accountStatementResponseDTO.setAccountHolderName(userDetails.getAccountHolderName());
        accountStatementResponseDTO.setAddress(userDetails.getAddress());
        accountStatementResponseDTO.setAccountNumber(userDetails.getAccountNumber());
        accountStatementResponseDTO.setIfscCode(userDetails.getIfscCode());
        accountStatementResponseDTO.setBranchName(userDetails.getBranchName());
        accountStatementResponseDTO.setAccountType(userDetails.getAccountType());

        log.info("transaction table details");
       List <Transaction> transactionResponseDTOList = transactionRepository.getTransactionData(
                transactionRequestDTO.getStatus().toString(),
                transactionRequestDTO.getFromAccountNumber(),
                transactionRequestDTO.getFromDate(),
                transactionRequestDTO.getToDate()
        );
//        List<Transaction> transactionResponseDTOList = transactionRepository.findByAccountNumber( transactionRequestDTO.getFromAccountNumber());

        if (transactionResponseDTOList.isEmpty()) {
            log.info("No transactions found for the provided criteria.");
        }

        accountStatementResponseDTO.setTransactions(transactionResponseDTOList);

        log.info("Transaction data:" +transactionResponseDTOList);

        log.info("Account statement data:" +accountStatementResponseDTO);


        return ResponseEntity.ok().body(BaseResponse.builder()
                .data(accountStatementResponseDTO)
                .message(TRANSACTION_DATA)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build());
    }


    private static TransactionResponseDTO getTransactionResponseDTO(Transaction transaction) {


        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
        transactionResponseDTO.setTransId(transaction.getTransId());
        transactionResponseDTO.setFromAccountNumber(transaction.getUserAccount().getAccountNumber());
        transactionResponseDTO.setToAccountId(transaction.getToAccountId());
        transactionResponseDTO.setTransDateTime(transaction.getTransDateTime());
        transactionResponseDTO.setAmount(transaction.getAmount());
        transactionResponseDTO.setStatus(transaction.getStatus());

        return transactionResponseDTO;
    }


}

