package com.coralogix.calculator.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coralogix.calculator.model.Rate;

@Component
public class RatesClient {
	
	private static final String URL = "http://localhost:8080/fixer/latest?base={base}&symbols={symbols}";

	@Autowired
	private RestTemplate restTemplate;
	
	public Rate getRates(String originCurrency, String finalCurrency) {
		
		Map<String, String> variables = new HashMap<>();
		
		variables.put("base", originCurrency);
		variables.put("symbols", finalCurrency);
		
		Rate rate = restTemplate.getForObject(URL, Rate.class,	variables);
		return rate;
	}
}
