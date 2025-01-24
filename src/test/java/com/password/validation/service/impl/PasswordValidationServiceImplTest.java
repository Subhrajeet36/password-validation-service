package com.password.validation.service.impl;

import com.password.validation.configuration.PasswordConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PasswordValidationServiceImplTest {

    @Mock
    private PasswordConfiguration passwordConfiguration;

    @InjectMocks
    private PasswordValidationServiceImpl passwordValidationService;



    @Test
    void validPassword_allTrue() {

        given(passwordConfiguration.isAtLeastOneUpperCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneLowerCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneSpecialCharacter()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneNumber()).willReturn(true);
        given(passwordConfiguration.isMinimumEightCharacters()).willReturn(true);
        String password = "Password1!";
        boolean isPasswordValid = passwordValidationService.passwordIsValid(password);
        assertTrue(isPasswordValid);
    }

    @Test
    void validPassword_allTrue_NoUpper() {

        given(passwordConfiguration.isAtLeastOneUpperCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneLowerCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneSpecialCharacter()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneNumber()).willReturn(true);
        given(passwordConfiguration.isMinimumEightCharacters()).willReturn(true);
        String password = "password1!";
        boolean isPasswordValid = passwordValidationService.passwordIsValid(password);
        assertFalse(isPasswordValid);
    }

    @Test
    void validPassword_allTrue_NoNumber() {

        given(passwordConfiguration.isAtLeastOneUpperCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneLowerCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneSpecialCharacter()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneNumber()).willReturn(true);
        given(passwordConfiguration.isMinimumEightCharacters()).willReturn(true);
        String password = "Password!";
        boolean isPasswordValid = passwordValidationService.passwordIsValid(password);
        assertFalse(isPasswordValid);
    }

    @Test
    void validPassword_allTrue_NoSpecial() {

        given(passwordConfiguration.isAtLeastOneUpperCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneLowerCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneSpecialCharacter()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneNumber()).willReturn(true);
        given(passwordConfiguration.isMinimumEightCharacters()).willReturn(true);
        String password = "Password1";
        boolean isPasswordValid = passwordValidationService.passwordIsValid(password);
        assertFalse(isPasswordValid);
    }

    @Test
    void validPassword_allTrue_LessThan8() {

        given(passwordConfiguration.isAtLeastOneUpperCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneLowerCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneSpecialCharacter()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneNumber()).willReturn(true);
        given(passwordConfiguration.isMinimumEightCharacters()).willReturn(true);
        String password = "Pord1!";
        boolean isPasswordValid = passwordValidationService.passwordIsValid(password);
        assertFalse(isPasswordValid);
    }

    @Test
    void validPassword_UpperCaseFalse() {

        given(passwordConfiguration.isAtLeastOneUpperCase()).willReturn(false);
        given(passwordConfiguration.isAtLeastOneLowerCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneSpecialCharacter()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneNumber()).willReturn(true);
        given(passwordConfiguration.isMinimumEightCharacters()).willReturn(true);
        String password = "password1!";
        boolean isPasswordValid = passwordValidationService.passwordIsValid(password);
        assertTrue(isPasswordValid);
    }


    @Test
    void validPassword_Min8False() {

        given(passwordConfiguration.isAtLeastOneUpperCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneLowerCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneSpecialCharacter()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneNumber()).willReturn(true);
        given(passwordConfiguration.isMinimumEightCharacters()).willReturn(false);
        String password = "Pasd1!";
        boolean isPasswordValid = passwordValidationService.passwordIsValid(password);
        assertTrue(isPasswordValid);
    }

    @Test
    void validPassword_SpecialCharacterFalse() {

        given(passwordConfiguration.isAtLeastOneUpperCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneLowerCase()).willReturn(true);
        given(passwordConfiguration.isAtLeastOneSpecialCharacter()).willReturn(false);
        given(passwordConfiguration.isAtLeastOneNumber()).willReturn(true);
        given(passwordConfiguration.isMinimumEightCharacters()).willReturn(true);
        String password = "Password1";
        boolean isPasswordValid = passwordValidationService.passwordIsValid(password);
        assertTrue(isPasswordValid);
    }


}