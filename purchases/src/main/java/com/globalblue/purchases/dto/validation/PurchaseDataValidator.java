package com.globalblue.purchases.dto.validation;

import com.globalblue.purchases.dto.PurchaseDTO;
import com.globalblue.purchases.dto.validation.annotation.PurchaseDataValidation;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PurchaseDataValidator implements ConstraintValidator<PurchaseDataValidation, PurchaseDTO> {
    @Override
    public boolean isValid(PurchaseDTO purchaseDTO, ConstraintValidatorContext constraintValidatorContext) {
        int sumOfInputs = 0;
        sumOfInputs += isNotNull(purchaseDTO.getVat());
        sumOfInputs += isNotNull(purchaseDTO.getGross());
        sumOfInputs += isNotNull(purchaseDTO.getNet());


        return sumOfInputs == 1;
    }

    /**
     * this methods check if the value is greater than zero.
     * - if it was true return 1
     * - if it was false return 0
     *
     * @param value is a double value
     * @return 1 or 0
     */
    private int isNotNull(Double value) {
        if (value != null && value > 0) {
            return 1;
        }
        return 0;
    }

}
