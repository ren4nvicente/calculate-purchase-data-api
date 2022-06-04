package com.globalblue.purchases.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class PurchaseData {
    private Integer VATRate;
    private Double VAT;
    private Double net;
    private Double gross;
}
