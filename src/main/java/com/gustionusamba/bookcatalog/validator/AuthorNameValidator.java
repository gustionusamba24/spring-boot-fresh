package com.gustionusamba.bookcatalog.validator;

import com.gustionusamba.bookcatalog.validator.annotation.ValidAuthorName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class AuthorNameValidator implements ConstraintValidator<ValidAuthorName, String> {

    @Override
    public boolean isValid(String authorName, ConstraintValidatorContext constraintValidatorContext) {
        return !authorName.equalsIgnoreCase("Miya");
    }
}
