package com.coralogix.calculator.model;

import java.io.Serializable;
import java.util.Map;

public class Rate implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean success;
	
	private Long timestamp;
	
	private String base;
	
	private String date;
	
	private Map<String, String> rates;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}
	
	
}
