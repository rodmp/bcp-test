package com.coralogix.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.coralogix.calculator.domain.ExchangeRate;
import com.coralogix.calculator.services.MatrixService;
import com.coralogix.calculator.services.RatesService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api")
public class RatesController {

	private final RatesService ratesService;

	private final MatrixService matrixService;

	public RatesController(final RatesService ratesService, final MatrixService matrixService) {
		this.ratesService = ratesService;
		this.matrixService = matrixService;
	}

	@GetMapping("/rates")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ExchangeRate> endPointsgetExchangeRatey(@RequestParam("originCurrency") String originCurrency,
			@RequestParam("finalCurrency") String finalCurrency) {
		return this.ratesService.processRates(originCurrency, finalCurrency);
	}

	@GetMapping("/matrix")
	public ResponseEntity<Void> getMatrizByValue(@RequestParam("userValue") Integer userValue) {
		matrixService.generateMatrix(userValue);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
