package com.coralogix.calculator.services;

import org.springframework.stereotype.Service;

import com.coralogix.calculator.client.RatesClient;
import com.coralogix.calculator.domain.ExchangeRate;
import com.coralogix.calculator.model.Rate;
import com.coralogix.calculator.repository.RateRepository;

import reactor.core.publisher.Mono;

@Service
public class RatesService {

	private final RatesClient ratesClient;

	private final RateRepository rateRepository;

	public RatesService(final RatesClient ratesClient, final RateRepository rateRepository) {
		this.ratesClient = ratesClient;
		this.rateRepository = rateRepository;
	}

	public Mono<ExchangeRate> processRates(String originCurrency, String finalCurrency) {
		Rate rate = this.ratesClient.getRates(originCurrency, finalCurrency);

		ExchangeRate exchangeRate = new ExchangeRate(rate.getBase(), finalCurrency, rate.getDate(),
				rate.getRates().get(finalCurrency));
		Mono<ExchangeRate> exchangeRateMono = this.rateRepository.save(exchangeRate);

		return exchangeRateMono;
	}
}
