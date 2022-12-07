package com.coralogix.calculator.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("exchange_rate")
public class ExchangeRate {
	
	@Id
	@Column
	private Long id;

	@Column("origin_currency")
	private String originCurrency;
	
	@Column("final_currency")
	private String finalCurrency;
	
	@Column
	private String date;
	
	@Column
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginCurrency() {
		return originCurrency;
	}

	public void setOriginCurrency(String originCurrency) {
		this.originCurrency = originCurrency;
	}

	public String getFinalCurrency() {
		return finalCurrency;
	}

	public void setFinalCurrency(String finalCurrency) {
		this.finalCurrency = finalCurrency;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ExchangeRate(String originCurrency, String finalCurrency, String date, String value) {
		this.originCurrency = originCurrency;
		this.finalCurrency = finalCurrency;
		this.date = date;
		this.value = value;
	}
	
	
}
