package com.example.demosecurity2.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniquerUserEmailValidator.class)

public @interface UniquerUserEmail {

    String message() default "Invalid email";

    Class<?>[] groups() default  {};

    Class<? extends Payload[]>[] payload() default {};
}
