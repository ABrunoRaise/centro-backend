package com.tecnositaf.backend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import com.tecnositaf.backend.exception.CustomException;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.repository.UserRepository;
import com.tecnositaf.backend.utility.UserUtility;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository; 
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	public List<User> getUserList() {
		
		log.info("In get user list");
		return userRepository.getUserList();
	
	}

	public User getUserById(Long idUser) {
		
		log.info("In get user by id");
		User userFound = userRepository.getUserById(idUser);
		if (userFound == null)
			throw new CustomException(ResponseErrorEnum.ERR_MISSINGRESOURCE, HttpStatus.UNAUTHORIZED);
		return userFound;

	}
	
	public Integer addUser(User userToInsert) {
		
		log.info("In insert user");
		int numRowsAffected = userRepository.addUser(userToInsert);
		if (numRowsAffected != 1)
			throw new CustomException(ResponseErrorEnum.ERR_MISSINGRESOURCE, HttpStatus.BAD_REQUEST);
		return numRowsAffected;
	}

	public Integer deleteUser(User userToDelete) {

		log.info("In delete user");
		int numRowsAffected = userRepository.deleteUserById(userToDelete.getIdUser());
		if (numRowsAffected != 1)
			throw new CustomException(ResponseErrorEnum.ERR_MISSINGRESOURCE, HttpStatus.BAD_REQUEST);
		return numRowsAffected;

	}

	public Integer updateUserById(User updatedSurvey) {

		log.info("In update user");
		int numRowsAffected = userRepository.updateUserById(updatedSurvey);
		if (numRowsAffected != 1)
			throw new CustomException(ResponseErrorEnum.ERR_MISSINGRESOURCE, HttpStatus.BAD_REQUEST);
		return numRowsAffected;

	}

}
