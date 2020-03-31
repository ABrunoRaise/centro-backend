package com.tecnositaf.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecnositaf.backend.mapper.UserMapper;
import com.tecnositaf.backend.model.User;

@Repository
public class UserRepository {

	@Autowired 
	UserMapper userMapper;
	
	public List<User> getUserList(){
		return userMapper.getUserList();
	}

	public User getUserById(Long idUser) {
		return userMapper.getUserById(idUser);
	}
	
	public Integer addUser(User userToInsert) {
		return userMapper.addUser(userToInsert);
	}

	public Integer deleteUserById(Long idUser) {
		return userMapper.deleteUser(idUser);
	}

	public Integer updateUserById(User updatedUser) {
		return userMapper.updateUser(updatedUser);
		
	}
}
