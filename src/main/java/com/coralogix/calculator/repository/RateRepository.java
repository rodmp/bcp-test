package com.coralogix.calculator.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.coralogix.calculator.domain.ExchangeRate;
import com.coralogix.calculator.model.Rate;

public interface RateRepository extends ReactiveCrudRepository<ExchangeRate, Long> {

}
