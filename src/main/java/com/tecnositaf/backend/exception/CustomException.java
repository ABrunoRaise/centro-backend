package com.tecnositaf.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;

//TODO remove this @ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	//TODO private HttpStatus httpStatus;
	private ResponseErrorEnum responseError;

	public CustomException(ResponseErrorEnum responseError) {
		this.responseError = responseError;
	}

	public ResponseErrorEnum getResponseError() {
		return responseError;
	}

	public void setResponseError(ResponseErrorEnum responseError) {
		this.responseError = responseError;
	}
	
}
