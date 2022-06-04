package com.globalblue.purchases.dto.validation;

import com.globalblue.purchases.dto.validation.annotation.VATRateValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class VATRateValidator implements ConstraintValidator<VATRateValidation, Integer> {
    private List<Integer> vatRate = List.of(10, 13, 20);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        return vatRate.contains(value);
    }
}
