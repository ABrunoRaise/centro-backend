package com.tecnositaf.backend.controller;

import java.util.List;

import com.tecnositaf.backend.dto.DTOUser;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import com.tecnositaf.backend.exception.CustomException;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.response.userResponse.*;
import com.tecnositaf.backend.service.UserService;
import com.tecnositaf.backend.utility.UserUtility;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<GetUsersResponse> getUsers(){
		
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
			@ApiParam(value = "IdUser not required") DTOUser addedDTOUser) {
		if (!UserUtility.isValidUserInsert(addedDTOUser))
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDFIELD,HttpStatus.BAD_REQUEST);
		User addedUser = addedDTOUser.toUser();
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
			@RequestBody DTOUser updatedDTOUser){
		
		if(!UserUtility.isValidIdUser(updatedDTOUser))
			throw new CustomException(ResponseErrorEnum.ERR_INALIDUSERFIELD,HttpStatus.UNAUTHORIZED);
		if (!UserUtility.isValidUser(updatedDTOUser))
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDFIELD,HttpStatus.BAD_REQUEST);
		User updatedUser = updatedDTOUser.toUser();
		userService.updateUserById(updatedUser);
		List<User> updatedUserList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new UpdateUserByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				updatedUserList				
			));
		
	}
	@DeleteMapping("/{idUser}")
	public ResponseEntity<DeleteUserByIdResponse> deleteUserById(@PathVariable Long idUser) {
		
		User userToDelete = userService.getUserById(idUser);
		userService.deleteUser(userToDelete);
		List<User> updatedUserList = userService.getUserList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new DeleteUserByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				updatedUserList
			));
		
	}
}
