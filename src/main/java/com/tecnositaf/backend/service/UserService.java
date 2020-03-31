package com.tecnositaf.backend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import com.tecnositaf.backend.exception.CustomException;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.repository.UserRepository;
import com.tecnositaf.backend.utility.DateUtility;
import com.tecnositaf.backend.utility.UserUtility;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository; 
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	public List<User> getUserList() {
		
		log.info("In get user list");
		List<User> rawUserList = userRepository.getUserList();
		return UserUtility.setAge(rawUserList);
	
	}

	public User getUserById(Long idUser) {
		
		log.info("In get user by id");
		User userFound = userRepository.getUserById(idUser);
		if (userFound == null)
			throw new CustomException(ResponseErrorEnum.ERR_MISSINGRESOURCE);
		int age = DateUtility.calculateDifferenceYear(userFound.getBirthday());
		userFound.setAge(age);
		return userFound;

	}
	
	public void addUser(User userToInsert) {
		
		log.info("In insert user");
		userRepository.addUser(userToInsert);
		
	}

	public void deleteSurvey(User userToDelete) {
		log.info("In delete user");
		userRepository.deleteUserById(userToDelete.getIdUser());
	}

}
