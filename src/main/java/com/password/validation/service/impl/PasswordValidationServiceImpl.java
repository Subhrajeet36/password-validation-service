package com.password.validation.service.impl;

import com.password.validation.configuration.PasswordConfiguration;
import com.password.validation.service.PasswordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidationServiceImpl implements PasswordValidationService {

    @Autowired
    private PasswordConfiguration passwordConfiguration;

    @Override
    public boolean passwordIsValid(String password) {

        String regex = "^";
        if(passwordConfiguration.isAtLeastOneUpperCase())
            regex = regex.concat("(?=.*?[A-Z])");
        if(passwordConfiguration.isAtLeastOneLowerCase())
            regex = regex.concat("(?=.*?[a-z])");
        if(passwordConfiguration.isAtLeastOneNumber())
            regex = regex.concat("(?=.*?[0-9])");
        if(passwordConfiguration.isAtLeastOneSpecialCharacter())
            regex = regex.concat("(?=.*?[^A-Za-z0-9])");
        if(passwordConfiguration.isMinimumEightCharacters())
            regex = regex.concat(".{8,}$");
        else
            regex = regex.concat(".{0,}$");




        return password.matches(regex);
    }
}
