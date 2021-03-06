package com.tecnositaf.backend.response.userResponse;

import java.util.ArrayList;
import java.util.List;

import com.tecnositaf.backend.dto.DTOUser;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.response.Response;

public class AddUserResponse extends Response {

	int numberOfUser;
	List<DTOUser> userList;
	
	public AddUserResponse(int code, String message, String path, List<User> userList) {
		super(code, message, path);
		this.userList = new ArrayList<>();
		userList.forEach(user ->
				this.userList.add(user.toDtoUser())
		);
		this.numberOfUser = userList.size();
	}
	
	public AddUserResponse(String path, List<User> userList) {
		super(0,"Success",path);
		this.userList = new ArrayList<>();
		userList.forEach(user ->
				this.userList.add(user.toDtoUser())
		);
		this.numberOfUser = userList.size();
	}

	public int getNumberOfUser() {
		return numberOfUser;
	}

	public void setNumberOfUser(int numberOfUser) {
		this.numberOfUser = numberOfUser;
	}

	public List<DTOUser> getUserList() {
		return userList;
	}

	public void setUserList(List<DTOUser> userList) {
		this.userList = userList;
	}
	
}
