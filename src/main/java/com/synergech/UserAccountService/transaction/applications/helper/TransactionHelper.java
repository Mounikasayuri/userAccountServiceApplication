package com.synergech.UserAccountService.transaction.applications.helper;

import com.synergech.UserAccountService.transaction.contracts.output.TransactionFilterResponseDTO;
import com.synergech.UserAccountService.transaction.contracts.output.UserDetailsResultSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionHelper {

    public List<TransactionFilterResponseDTO> transformToTransactionFilterResponse(List<UserDetailsResultSet> userDetailsResultSets) {
        List<TransactionFilterResponseDTO> transactionFilterResponseDTOList = new ArrayList<>();
        for (UserDetailsResultSet userDetails : userDetailsResultSets) {
            TransactionFilterResponseDTO transactionFilterResponseDTO = new TransactionFilterResponseDTO();
            transactionFilterResponseDTO.setTransId(userDetails.getTransId());
            transactionFilterResponseDTO.setFromAccountNumber(userDetails.getFromAccountNumber());
            transactionFilterResponseDTO.setToAccountId(userDetails.getToAccountId());
            transactionFilterResponseDTO.setTransDateTime(userDetails.getTransDateTime());
            transactionFilterResponseDTO.setAmount(userDetails.getAmount());
            transactionFilterResponseDTO.setStatus(userDetails.getStatus());
            transactionFilterResponseDTOList.add(transactionFilterResponseDTO);
        }
        return transactionFilterResponseDTOList;
    }

}
