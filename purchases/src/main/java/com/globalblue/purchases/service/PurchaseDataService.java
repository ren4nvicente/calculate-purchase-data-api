package com.globalblue.purchases.service;

import com.globalblue.purchases.domain.PurchaseData;

public interface PurchaseDataService {

    /**
     * It calculates data purchase by gross and vatRate
     */
    PurchaseData calculatePurchaseDataByGross(Double gross, Integer vatRate);

    /**
     * It calculates data purchase by net and vatRate
     */
    PurchaseData calculatePurchaseDataByNet(Double net, Integer vatRate);

    /**
     * It calculates data purchase by vat and vatRate
     */
    PurchaseData calculatePurchaseDataByVat(Double vat, Integer vatRate);
}
