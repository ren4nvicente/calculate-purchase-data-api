package com.globalblue.purchases;

import com.globalblue.purchases.controller.PurchasesController;
import com.globalblue.purchases.dto.PurchaseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PurchasesControllerTest {
	private static Integer VAT_RATE = 10;
	private static Double VAT = 10.0;
	private static Double GROSS = 110.0;
	private static Double NET = 100.0;
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private PurchasesController controller;
	private static PurchaseDTO expectedResult;
	private static List<String> errorList;

	@BeforeAll
	public static void setUp() {
		expectedResult = new PurchaseDTO();
		expectedResult.setVatRate(VAT_RATE);
		expectedResult.setVat(VAT);
		expectedResult.setNet(NET);
		expectedResult.setGross(GROSS);

		errorList = List.of("The 'vatRate' must be one of the valid rates 10%,13% or 20%."
				,"Please inform just one of the theses values net,gross or VAT.");

	}

	@Test
	public void calculatePurchaseDataTest(){
		PurchaseDTO dto = new PurchaseDTO();
		dto.setVatRate(10);
		dto.setNet(100.0);

		ResponseEntity<PurchaseDTO> result = restTemplate.postForEntity("http://localhost:"+port+"/api/calculate-purchases-data",dto, PurchaseDTO.class);
		Assertions.assertEquals(expectedResult,result.getBody());
	}

	@Test
	public void calculatePurchaseDataErrorHandleTest(){
		PurchaseDTO dto = new PurchaseDTO();
		ResponseEntity<List> result = restTemplate.postForEntity("http://localhost:"+port+"/api/calculate-purchases-data",dto, List.class);
		for(String error : (List<String>)result.getBody()){
			Assertions.assertTrue(errorList.contains(error));
		}
	}



}
