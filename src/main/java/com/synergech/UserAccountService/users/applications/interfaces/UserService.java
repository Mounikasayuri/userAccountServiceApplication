package com.synergech.UserAccountService.users.applications.interfaces;

import com.synergech.UserAccountService.users.contracts.input.UserRequestDTO;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    public ResponseEntity<BaseResponse> getAllUsers();

    public ResponseEntity<BaseResponse> getUserById(Long id);

    public ResponseEntity<BaseResponse> addUser(UserRequestDTO user);

    public ResponseEntity<BaseResponse> updateUser(long id, UserRequestDTO user);

    public ResponseEntity<BaseResponse> deleteUserById(Long id);

}
