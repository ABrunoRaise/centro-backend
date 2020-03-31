package com.tecnositaf.backend.enumeration;

public enum ResponseErrorEnum {

	ERR_MISSINGRESOURCE(1,"Resource not found"),
	ERR_INVALIDFIELD(2,"Invalid fields entered"),
	ERR_INVALIDSURVEYFIELD(3,"Survey cannot be null"),
	ERR_INVALIDPERIOD(4,"Invalid period of time entered");
	
	private int code;
	private String message;
	
	private ResponseErrorEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}	
	
}