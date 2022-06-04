package com.globalblue.purchases.dto.validation.annotation;

import com.globalblue.purchases.dto.validation.PurchaseDataValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PurchaseDataValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PurchaseDataValidation {
    String message() default "Please inform just one of the theses values net,gross or VAT.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
