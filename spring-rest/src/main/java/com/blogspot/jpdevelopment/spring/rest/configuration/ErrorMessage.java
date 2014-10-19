package com.blogspot.jpdevelopment.spring.rest.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMessage {

	private String resource;
	private int code;
	private String message;

	public ErrorMessage(Exception e, String resource) {
		this.message = e.getMessage();
		this.resource = resource;
	}

	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
