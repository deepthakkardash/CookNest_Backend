package com.cooknest.cooknest.in;


import com.cooknest.cooknest.in.validator.UniqueUsernameValidators;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = UniqueUsernameValidators.class)
@Target({ FIELD})
@Retention(RUNTIME)
public @interface UniqueUsername {

    String message() default "Username already used";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
