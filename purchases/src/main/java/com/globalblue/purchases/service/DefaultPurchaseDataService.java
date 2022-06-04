package com.globalblue.purchases.service;

import com.globalblue.purchases.domain.PurchaseData;
import org.springframework.stereotype.Service;

@Service
public class DefaultPurchaseDataService implements PurchaseDataService {

    @Override
    public PurchaseData calculatePurchaseDataByGross(Double gross, Integer vatRate) {
        Double vat = calculateVatByGross(gross, vatRate);
        Double net = calculateNetByVat(vat, vatRate);
        return new PurchaseData(vatRate, vat, net, gross);
    }

    @Override
    public PurchaseData calculatePurchaseDataByNet(Double net, Integer vatRate) {
        Double vat = calculateVatByNet(net, vatRate);
        Double gross = calculateGrossByVat(vat, vatRate);
        return new PurchaseData(vatRate, vat, net, gross);
    }

    @Override
    public PurchaseData calculatePurchaseDataByVat(Double vat, Integer vatRate) {
        Double gross = calculateGrossByVat(vat, vatRate);
        Double net = calculateNetByVat(vat, vatRate);
        return new PurchaseData(vatRate, vat, net, gross);
    }

    /**
     * It Calculates the vat by gross and vatRate
     */
    private Double calculateVatByGross(Double gross, Integer vatRate) {
        return (gross * vatRate) / (100 + vatRate);
    }

    /**
     * It Calculates the gross by vat and vatRate
     */
    private Double calculateGrossByVat(Double vat, Integer vatRate) {
        return ((vat * 100) / vatRate) + vat;
    }

    /**
     * It Calculates the net by vat and vatRate
     */
    private Double calculateNetByVat(Double vat, Integer vatRate) {
        return ((vat * 100) / vatRate);
    }

    /**
     * It Calculates the vat by net and vatRate
     */
    private Double calculateVatByNet(Double net, Integer vatRate) {
        return (net * vatRate / 100);
    }
}
