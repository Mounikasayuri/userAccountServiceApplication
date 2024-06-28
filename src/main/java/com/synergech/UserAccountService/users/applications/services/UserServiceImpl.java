package com.synergech.UserAccountService.users.applications.services;

import com.synergech.UserAccountService.users.contracts.input.UserRequestDTO;
import com.synergech.UserAccountService.shared.exceptions.NotFoundException;
import com.synergech.UserAccountService.shared.responses.BaseResponse;
import com.synergech.UserAccountService.users.applications.interfaces.UserService;
import com.synergech.UserAccountService.users.contracts.output.UserResponseDTO;
import com.synergech.UserAccountService.users.domain.model.User;
import com.synergech.UserAccountService.users.domain.repository.UserRepository;
import com.synergech.UserAccountService.users.infrastructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.synergech.UserAccountService.account.constants.MessageConstants.INVALID_ID;
import static com.synergech.UserAccountService.users.constants.MessageConstants.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity<BaseResponse> getAllUsers() {

        List<User> userData = userRepository.findAll();
        return ResponseEntity.ok().body((BaseResponse.builder()
                .data(userData)
                .message(USER_DATA_FETCHED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build()));
    }

    @Override
    public ResponseEntity<BaseResponse> getUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException(INVALID_ID));
        return ResponseEntity.ok().body((BaseResponse.builder()
                .data(user)
                .message(USER_DATA_FETCHED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build()));
    }

    @Override
    public ResponseEntity<BaseResponse> addUser(UserRequestDTO userRequestDTO) {

        User user = userMapper.userDetails(userRequestDTO);
        User userData = userRepository.save(user);

        UserResponseDTO userResponseDTO = getUserResponseDTO(userData);

        return ResponseEntity.ok().body(BaseResponse.builder()
                .data(userResponseDTO)
                .message(USER_CREATED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build());
    }


    @Override
    public ResponseEntity<BaseResponse> updateUser(long id, UserRequestDTO userRequestDTO) {

        User user = userMapper.userDetails(userRequestDTO);
        User userDetails = userRepository.findById(id).orElseThrow(() -> new NotFoundException(INVALID_ID));
        userDetails.setUserName(user.getUserName());
        userDetails.setAge(user.getAge());
        userDetails.setDob(user.getDob());
        userDetails.setEmail(user.getEmail());
        userDetails.setAddress(user.getAddress());
        userDetails.setGender(user.getGender());
        userDetails.setMobileNumber(user.getMobileNumber());
        User updatedUser = userRepository.save(userDetails);

        UserResponseDTO userResponseDTO = getUserResponseDTO(updatedUser);

        return ResponseEntity.ok().body(BaseResponse.builder()
                .data(userResponseDTO)
                .message(USER_UPDATED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build());
    }

    @Override
    public ResponseEntity<BaseResponse> deleteUserById(Long id) {

        userRepository.deleteById(id);
        return ResponseEntity.ok().body((BaseResponse.builder()
                .data(id)
                .message(USER_DELETED)
                .status(SUCCESS)
                .code(HttpStatus.OK.value())
                .build()));
    }

    private static UserResponseDTO getUserResponseDTO(User userData) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(userData.getUserId());
        userResponseDTO.setUserName(userData.getUserName());
        userResponseDTO.setAge(userData.getAge());
        userResponseDTO.setGender(userData.getGender());
        userResponseDTO.setDob(userData.getDob());
        userResponseDTO.setEmail(userData.getEmail());
        userResponseDTO.setAddress(userData.getAddress());
        userResponseDTO.setMobileNumber(userData.getMobileNumber());
        return userResponseDTO;
    }
}
