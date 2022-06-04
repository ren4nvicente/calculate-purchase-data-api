package com.globalblue.purchases.dto;

import com.globalblue.purchases.domain.PurchaseData;
import com.globalblue.purchases.dto.validation.annotation.PurchaseDataValidation;
import com.globalblue.purchases.dto.validation.annotation.VATRateValidation;
import lombok.Data;

@Data
@PurchaseDataValidation
public class PurchaseDTO {
    @VATRateValidation
    private Integer vatRate;

    private Double vat;
    private Double net;
    private Double gross;

    public PurchaseDTO(PurchaseData purchaseData) {
        this.vatRate = purchaseData.getVATRate();
        this.vat = purchaseData.getVAT();
        this.net = purchaseData.getNet();
        this.gross = purchaseData.getGross();
    }

    public PurchaseDTO() {
    }
}
