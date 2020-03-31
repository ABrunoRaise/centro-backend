package com.tecnositaf.backend.response.userResponse;

import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.response.Response;

public class GetUserByIdResponse extends Response{

	User user;
	
	public GetUserByIdResponse(int code, String message, String path, User user) {
		super(code, message, path);
		this.user = user;
	}

	public GetUserByIdResponse(String path, User user) {
		super(0, "Success" , path);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
