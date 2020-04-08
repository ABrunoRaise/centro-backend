package com.tecnositaf.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;

public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;
	private ResponseErrorEnum responseError;

	public CustomException(ResponseErrorEnum responseError, HttpStatus httpStatus) {
		this.responseError = responseError;
		this.httpStatus = httpStatus;
	}

	public ResponseErrorEnum getResponseError() {
		return responseError;
	}

	public void setResponseError(ResponseErrorEnum responseError) {
		this.responseError = responseError;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
