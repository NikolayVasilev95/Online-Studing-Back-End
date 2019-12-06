package com.branstarstech.nikolay.OlnineStuding.web.rest.controller;

import com.branstarstech.nikolay.OlnineStuding.domain.User;
import com.branstarstech.nikolay.OlnineStuding.resorces.UserDTO;
import com.branstarstech.nikolay.OlnineStuding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://online-studying.herokuapp.com/", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/register", produces = MediaType.APPLICATION_JSON_VALUE)
public class Register {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody UserDTO usersDTO){
        if (userService.findByNameOrEmail(usersDTO.getName(), usersDTO.getEmail()).isPresent()){
            return  ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        usersDTO.setPassword(passwordEncoder.encode(usersDTO.getPassword()));
        User user = new User(usersDTO);
        user = userService.createUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
