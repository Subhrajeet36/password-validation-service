package com.password.validation.configuration;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PasswordConfiguration {

    @Value("${password.validation.minimum-eight-characters}")
    private boolean minimumEightCharacters;

    @Value("${password.validation.at-least-one-upper}")
    private boolean atLeastOneUpperCase;

    @Value("${password.validation.at-least-one-lower}")
    private boolean atLeastOneLowerCase;

    @Value("${password.validation.at-least-one-number}")
    private boolean atLeastOneNumber;

    @Value("${password.validation.at-least-one-special}")
    private boolean atLeastOneSpecialCharacter;
}
