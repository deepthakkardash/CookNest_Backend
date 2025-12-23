package com.cooknest.cooknest.in.validator;

import com.cooknest.cooknest.in.UniqueUsername;
import com.cooknest.cooknest.in.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueUsernameValidators implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        if (value == null || value.isBlank()) {
            return true;
        }

        return !userRepository.existsByUsername(value);
    }
}
