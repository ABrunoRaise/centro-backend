package com.tecnositaf.backend.response.userResponse;

import com.tecnositaf.backend.dto.DTOUser;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.response.Response;

public class GetUserByIdResponse extends Response{

	DTOUser user;
	
	public GetUserByIdResponse(int code, String message, String path, User user) {
		super(code, message, path);
		this.user = user.toDtoUser();
	}

	public GetUserByIdResponse(String path, User user) {
		super(0, "Success" , path);
		this.user = user.toDtoUser();
	}

	public DTOUser getUser() {
		return user;
	}

	public void setUser(DTOUser user) {
		this.user = user;
	}
	
}
