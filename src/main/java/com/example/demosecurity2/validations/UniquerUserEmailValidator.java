package com.example.demosecurity2.validations;

import com.example.demosecurity2.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquerUserEmailValidator implements ConstraintValidator<UniquerUserEmail,String> {
    private final UserRepository userRepository;

    public UniquerUserEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userRepository.findByEmail(value).isEmpty();
    }
}
