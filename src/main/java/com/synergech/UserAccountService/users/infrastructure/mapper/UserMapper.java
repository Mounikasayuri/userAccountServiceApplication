package com.synergech.UserAccountService.users.infrastructure.mapper;


import com.synergech.UserAccountService.users.contracts.input.UserRequestDTO;
import com.synergech.UserAccountService.users.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User userDetails(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUserName(userRequestDTO.getUserName());
        user.setAge(userRequestDTO.getAge());
        user.setGender(userRequestDTO.getGender());
        user.setDob(userRequestDTO.getDob());
        user.setEmail(userRequestDTO.getEmail());
        user.setAddress(userRequestDTO.getAddress());
        user.setMobileNumber(userRequestDTO.getMobileNumber());
        return user;
    }


}
