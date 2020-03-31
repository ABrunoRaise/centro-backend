package com.tecnositaf.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import com.tecnositaf.backend.exception.CustomException;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.response.Response;
import com.tecnositaf.backend.response.userResponse.AddUserResponse;
import com.tecnositaf.backend.response.userResponse.GetUserByIdResponse;
import com.tecnositaf.backend.response.userResponse.GetUsersResponse;
import com.tecnositaf.backend.response.userResponse.RemoveUserByIdResponse;
import com.tecnositaf.backend.service.UserService;
import com.tecnositaf.backend.utility.UserUtility;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping(path = "/users")
	public ResponseEntity<Response> getTable(){
		
		List<User> userList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new GetUsersResponse( 
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(), 
				userList
			)
		);
		
	}
	
	@GetMapping(path = "users/{idUser}")
	public ResponseEntity<Response> getUserById(@PathVariable Long idUser) {
		
		User surveyToReturn = userService.getUserById(idUser);
		return  ResponseEntity.status(HttpStatus.OK).body(
			new GetUserByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				surveyToReturn
			));

	}
	
	
	@PostMapping(path = "/users")
	public ResponseEntity<Response> addUser(@RequestBody User addedUser) {
		
		if (!UserUtility.checkUserValidity(addedUser)) 
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDFIELD);	
		userService.addUser(addedUser); 
		List<User> updatedUserList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new AddUserResponse( 
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(), 
				updatedUserList
			));
		
	}
	
	@PutMapping(path = "users/{idUser}")
	
	@DeleteMapping(path = "users/{idUser}")
	public ResponseEntity<Response> removeUserById(@PathVariable Long idUser) {
		
		User userToDelete = userService.getUserById(idUser);
		userService.deleteSurvey(userToDelete);
		List<User> updatedSurveyList = userService.getUserList();  
		return ResponseEntity.status(HttpStatus.OK).body(
			new RemoveUserByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				updatedSurveyList
			));
		
	}
}
