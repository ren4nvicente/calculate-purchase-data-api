package com.globalblue.purchases;


import com.globalblue.purchases.domain.PurchaseData;
import com.globalblue.purchases.service.DefaultPurchaseDataService;
import com.globalblue.purchases.service.PurchaseDataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class PurchaseDataServiceTest {
    private static Integer VAT_RATE = 10;
    private static Double VAT = 10.0;
    private static Double GROSS = 110.0;
    private static Double NET = 100.0;


    private static PurchaseDataService purchaseDataService;
    private static PurchaseData expectedData;

    @BeforeAll
    public static void setUp() {
        purchaseDataService = new DefaultPurchaseDataService();
        expectedData = new PurchaseData(10, 10.0, 100.0, 110.0);
    }

    @Test
    public void calculatePurchaseDataByGross() {
        PurchaseData calculatedData = purchaseDataService.calculatePurchaseDataByGross(110.0, 10);
        Assertions.assertEquals(expectedData, calculatedData);
    }

    @Test
    public void calculatePurchaseDataByNet() {
        PurchaseData calculatedData = purchaseDataService.calculatePurchaseDataByNet(100.0, 10);
        Assertions.assertEquals(expectedData, calculatedData);
    }

    @Test
    public void calculatePurchaseDataByVat() {
        PurchaseData calculatedData = purchaseDataService.calculatePurchaseDataByGross(110.0, 10);
        Assertions.assertEquals(expectedData, calculatedData);
    }

}
