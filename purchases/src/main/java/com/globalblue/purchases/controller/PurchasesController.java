package com.globalblue.purchases.controller;

import com.globalblue.purchases.domain.PurchaseData;
import com.globalblue.purchases.dto.PurchaseDTO;
import com.globalblue.purchases.service.PurchaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PurchasesController {
    @Autowired
    private PurchaseDataService purchaseDataService;

    @PostMapping("/calculate-purchases-data")
    public ResponseEntity<PurchaseDTO> calculatePurchasesData(@Valid @RequestBody PurchaseDTO purchaseDTO) {
        Integer vatRate = purchaseDTO.getVatRate();
        PurchaseData calculatedPurchase = null;

        /*
            Checking the input type to calculate the purchase data
         */
        if (purchaseDTO.getVat() != null && purchaseDTO.getVat() > 0) {
            calculatedPurchase = purchaseDataService.calculatePurchaseDataByVat(purchaseDTO.getVat(), vatRate);
        } else if (purchaseDTO.getNet() != null && purchaseDTO.getNet() > 0) {
            calculatedPurchase = purchaseDataService.calculatePurchaseDataByNet(purchaseDTO.getNet(), vatRate);
        } else {
            calculatedPurchase = purchaseDataService.calculatePurchaseDataByGross(purchaseDTO.getGross(), vatRate);
        }

        return ResponseEntity.ok(new PurchaseDTO(calculatedPurchase));
    }

}
