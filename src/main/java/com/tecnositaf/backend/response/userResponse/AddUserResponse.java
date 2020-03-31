package com.tecnositaf.backend.response.userResponse;

import java.util.List;

import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.response.Response;

public class AddUserResponse extends Response {

	int numberOfUser;
	List<User> userList;
	
	public AddUserResponse(int code, String message, String path, List<User> userList) {
		super(code, message, path);
		this.userList = userList;
		this.numberOfUser = userList.size();
	}
	
	public AddUserResponse(String path, List<User> userList) {
		super(0,"Success",path);
		this.userList = userList;
		this.numberOfUser = userList.size();
	}

	public int getNumberOfUser() {
		return numberOfUser;
	}

	public void setNumberOfUser(int numberOfUser) {
		this.numberOfUser = numberOfUser;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
