package com.tecnositaf.backend.controller;

import java.util.List;

import io.swagger.annotations.ApiParam;
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
	public ResponseEntity<GetUsersResponse> getTable(){
		
		List<User> userList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new GetUsersResponse( 
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(), 
				userList
			)
		);
		
	}
	
	@GetMapping("/{idUser}")
	public ResponseEntity<GetUserByIdResponse> getUserById(@PathVariable Long idUser) {
		
		User surveyToReturn = userService.getUserById(idUser);
		return  ResponseEntity.status(HttpStatus.OK).body(
			new GetUserByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				surveyToReturn
			));

	}
	
	
	@PostMapping
	public ResponseEntity<AddUserResponse> addUser(
			@RequestBody
			@ApiParam(value = "JSON format input, idUser and age are not required.") User addedUser) {
		
		if (!UserUtility.isValidUser(addedUser))
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDFIELD,HttpStatus.BAD_REQUEST);
		userService.addUser(addedUser); 
		List<User> updatedUserList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new AddUserResponse( 
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(), 
				updatedUserList
			));
		
	}
	
	@PutMapping
	public ResponseEntity<UpdateUserByIdResponse> updateUserById(
			@RequestBody
			@ApiParam(value = "JSON format input, age is not required.") User updatedSurvey){
		
		if(!UserUtility.isValidIdUser(updatedSurvey))
			throw new CustomException(ResponseErrorEnum.ERR_INALIDUSERFIELD,HttpStatus.UNAUTHORIZED);
		if (!UserUtility.isValidUser(updatedSurvey))
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDFIELD,HttpStatus.BAD_REQUEST);
		userService.updateUserById(updatedSurvey); 
		List<User> updatedUserList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new UpdateUserByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				updatedUserList				
			));
		
	}
	@DeleteMapping("/{idUser}")
	public ResponseEntity<RemoveUserByIdResponse> removeUserById(@PathVariable Long idUser) {
		
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
