package com.synergech.UserAccountService.transaction.applications.services;

import com.synergech.UserAccountService.account.domain.model.UserAccount;
import com.synergech.UserAccountService.account.domain.repository.UserAccountRepository;
import com.synergech.UserAccountService.shared.exceptions.BadRequestException;
import com.synergech.UserAccountService.shared.exceptions.NotFoundException;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import com.synergech.UserAccountService.transaction.applications.interfaces.TransactionService;
import com.synergech.UserAccountService.transaction.contracts.input.TransactionRequestDTO;
import com.synergech.UserAccountService.transaction.contracts.output.TransactionResponseDTO;
import com.synergech.UserAccountService.transaction.domain.model.Transaction;
import com.synergech.UserAccountService.transaction.domain.repository.TransactionRepository;
import com.synergech.UserAccountService.transaction.infrastructure.mapper.TransactionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.synergech.UserAccountService.transaction.constants.MessageConstants.INVALID_ACCOUNT_NUMBER;
import static com.synergech.UserAccountService.transaction.constants.MessageConstants.TRANSACTION_CREATED;
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

