package com.tecnositaf.backend.controller;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecnositaf.backend.exception.CustomException;
import com.tecnositaf.backend.response.Response;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Response> handleGenericException(Exception ex, WebRequest request){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
			new Response(
				ResponseErrorEnum.ERR_GENERICERROR,
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
			));
		
	}
	
	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<Response> handleCustomException(CustomException ex, WebRequest request){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
			new Response(
				ex.getResponseError(),
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString()
			));
	}
	
}
