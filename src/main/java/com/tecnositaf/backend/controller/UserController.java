package com.tecnositaf.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import com.tecnositaf.backend.exception.CustomException;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.response.Response;
import com.tecnositaf.backend.response.userResponse.*;
import com.tecnositaf.backend.service.UserService;
import com.tecnositaf.backend.utility.UserUtility;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<Response> getTable(){
		
		List<User> userList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new GetUsersResponse( 
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(), 
				userList
			)
		);
		
	}
	
	@GetMapping("/{idUser}")
	public ResponseEntity<Response> getUserById(@PathVariable Long idUser) {
		
		User surveyToReturn = userService.getUserById(idUser);
		return  ResponseEntity.status(HttpStatus.OK).body(
			new GetUserByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				surveyToReturn
			));

	}
	
	
	@PostMapping
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
	
	@PutMapping
	public ResponseEntity<Response> updateUserById(@RequestBody User updatedSurvey){	
		
		if(!UserUtility.checkUserIDValidity(updatedSurvey))  
			throw new CustomException(ResponseErrorEnum.ERR_INALIDUSERFIELD);
		if (!UserUtility.checkUserValidity(updatedSurvey)) 
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDFIELD);		
		userService.updateUserById(updatedSurvey); 
		List<User> updatedUserList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new UpdateUserByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				updatedUserList				
			));
		
	}
	@DeleteMapping("/{idUser}")
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
