package com.synergech.UserAccountService.account.applications.services;

import com.synergech.UserAccountService.account.applications.interfaces.UserAccountService;
import com.synergech.UserAccountService.account.contracts.input.UserAccountRequestDTO;
import com.synergech.UserAccountService.account.contracts.output.UserAccountResponseDTO;
import com.synergech.UserAccountService.account.domain.model.UserAccount;
import com.synergech.UserAccountService.account.domain.repository.UserAccountRepository;
import com.synergech.UserAccountService.account.infrastructure.mapper.UserAccountMapper;
import com.synergech.UserAccountService.shared.exceptions.BadRequestException;
import com.synergech.UserAccountService.shared.exceptions.NotFoundException;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import com.synergech.UserAccountService.users.domain.model.User;
import com.synergech.UserAccountService.users.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.synergech.UserAccountService.account.constants.MessageConstants.*;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<BaseResponse> getAllUserAccounts() {
        List<UserAccount> userAccountData = userAccountRepository.findAll();
        return ResponseEntity.ok().body((BaseResponse.builder()
                .data(userAccountData)
                .message(USER_ACCOUNT_DATA_FETCHED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build()));
    }

    @Override
    public ResponseEntity<BaseResponse> getUserAccountByAccountNumber(Long accountNumber) {

        if (!userAccountRepository.existsById(accountNumber)) {
            throw new NotFoundException(INVALID_ACC_NUMBER);
        }

        UserAccount userAccount = userAccountRepository.findByAccountNumber(accountNumber);
        return ResponseEntity.ok().body((BaseResponse.builder()
                .data(userAccount)
                .message(USER_ACCOUNT_DATA_FETCHED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build()));

    }

    @Override
    public ResponseEntity<BaseResponse> createUserAccount(UserAccountRequestDTO userAccountRequestDTO) throws BadRequestException {

        UserAccount user = userAccountMapper.userAccountDetails(userAccountRequestDTO);
        User newUser = userRepository.getReferenceById(user.getUser().getUserId());

        if (!user.getMobileNumber().equalsIgnoreCase(newUser.getMobileNumber()) ||
                !user.getEmail().equalsIgnoreCase(newUser.getEmail())) {
            throw new BadRequestException(INVALID_MOBILE_OR_EMAIL);
        }

        UserAccount userData = userAccountRepository.save(user);

        UserAccountResponseDTO userAccountResponseDTO = getUserAccountResponseDTO(userData);
        return ResponseEntity.ok().body(BaseResponse.builder()
                .data(userAccountResponseDTO)
                .message(USER_ACCOUNT_CREATED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build());

    }

    @Override
    public ResponseEntity<BaseResponse> editUserAccount(long accountNumber, UserAccountRequestDTO userAccountRequestDTO) {

        UserAccount userAccountData = userAccountMapper.userAccountDetails(userAccountRequestDTO);
        UserAccount user = userAccountRepository.findById(accountNumber).orElseThrow(() -> new NotFoundException(INVALID_ACC_NUMBER));
        user.setAccountNumber(userAccountData.getAccountNumber());
        user.setAccountType(userAccountData.getAccountType());
        user.setIfscCode(userAccountData.getIfscCode());
        user.setBranch(userAccountData.getBranch());
        user.setMobileNumber(userAccountData.getMobileNumber());
        user.setEmail(userAccountData.getEmail());
        user.setPanCard(userAccountData.getPanCard());
        UserAccount updatedUserAccount = userAccountRepository.save(user);

        UserAccountResponseDTO userAccountResponseDTO = getUserAccountResponseDTO(updatedUserAccount);

        return ResponseEntity.ok().body(BaseResponse.builder()
                .data(userAccountResponseDTO)
                .message(USER_ACCOUNT_UPDATED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build());
    }

    @Transactional
    @Override
    public ResponseEntity<BaseResponse> deleteUserAccountById(Long accountNumber) {

        if (!userAccountRepository.existsById(accountNumber)) {
            throw new NotFoundException(INVALID_ACC_NUMBER);
        }
        userAccountRepository.deleteByAccountNumber(accountNumber);
        return ResponseEntity.ok().body((BaseResponse.builder()
                .data(accountNumber)
                .message(USER_ACCOUNT_DELETED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build()));
    }

    private static UserAccountResponseDTO getUserAccountResponseDTO(UserAccount userAccountData) {

        UserAccountResponseDTO user = new UserAccountResponseDTO();
        user.setUserId(userAccountData.getUser().getUserId());
        user.setAccountNumber(userAccountData.getAccountNumber());
        user.setAccountType(userAccountData.getAccountType());
        user.setIfscCode(userAccountData.getIfscCode());
        user.setBranch(userAccountData.getBranch());
        user.setMobileNumber(userAccountData.getMobileNumber());
        user.setEmail(userAccountData.getEmail());
        user.setPanCard(userAccountData.getPanCard());
        return user;
    }

}
