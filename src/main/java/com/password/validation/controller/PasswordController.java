package com.password.validation.controller;

import com.password.validation.model.Password;
import com.password.validation.service.PasswordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @Autowired
    private PasswordValidationService passwordValidationService;

    @PostMapping("/validate")
    public String validatePassword(@RequestBody  Password password) {
        if(passwordValidationService.passwordIsValid(password.getPassword()))
            return "Password is valid";
        else return "Password is not valid";
    }
}
