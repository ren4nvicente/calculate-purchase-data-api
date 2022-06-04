package com.globalblue.purchases.dto.validation.annotation;

import com.globalblue.purchases.dto.validation.VATRateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = VATRateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VATRateValidation {
    String message() default "The 'vatRate' must be one of the valid rates 10%,13% or 20%.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
