package com.example.controller;

import com.example.model.UserEntity;
import com.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

private UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> userSave(@RequestBody UserEntity userEntity) {

         if(!userService.addUser(userEntity)){
         return new ResponseEntity<>("A user with this name exists",HttpStatus.CONFLICT);
 }
         else
        return new ResponseEntity<>("You have successfully registered", HttpStatus.OK);
    }

}
