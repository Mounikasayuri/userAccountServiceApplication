package com.synergech.UserAccountService.users.controllers;

import com.synergech.UserAccountService.shared.responses.BaseResponse;
import com.synergech.UserAccountService.users.applications.services.UserServiceImpl;
import com.synergech.UserAccountService.users.contracts.input.UserRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getAll")
    public ResponseEntity<BaseResponse> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BaseResponse> getById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse> addUser(@Valid @RequestBody UserRequestDTO user){
        return userService.addUser(user);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable long id , @Valid @RequestBody UserRequestDTO user){
        return this.userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> deleteUser(@PathVariable long id){
        return userService.deleteUserById(id);
    }
}
