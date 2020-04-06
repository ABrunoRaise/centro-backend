package com.tecnositaf.backend.response.userResponse;

import java.util.ArrayList;
import java.util.List;

import com.tecnositaf.backend.dto.DTOUser;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.response.Response;

public class UpdateUserByIdResponse extends Response{

	int numberOfUsers;
	List<DTOUser> userList;
	
	public UpdateUserByIdResponse(int code, String message, String path, List<User> userList) {
		super(code, message, path);
		this.userList = new ArrayList<>();
		userList.forEach(user ->
				this.userList.add(user.toDtoUser())
		);
		this.numberOfUsers = userList.size();
	}
	
	public UpdateUserByIdResponse(String path, List<User> userList) {
		super(0,"Success",path);
		this.userList = new ArrayList<>();
		userList.forEach(user ->
				this.userList.add(user.toDtoUser())
		);
		this.numberOfUsers = userList.size();
	}

	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}

	public List<DTOUser> getUserList() {
		return userList;
	}

	public void setUserList(List<DTOUser> userList) {
		this.userList = userList;
	}
	
	
}
