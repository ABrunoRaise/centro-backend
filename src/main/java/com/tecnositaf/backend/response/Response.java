package com.tecnositaf.backend.response;

public class Response {
	
	int code;
	String message;
	String path;
	
	public Response(int code, String message, String path) {
		this.code = code;
		this.message = message;
		this.path = path;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
