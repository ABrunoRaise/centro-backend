package com.tecnositaf.backend.utility;

import java.util.List;

import com.tecnositaf.backend.dto.DTOUser;
import com.tecnositaf.backend.model.User;

public class UserUtility {

	/*
	public static List<User> setAgeOf(List<User> rawUserList){
		
		for(User currentUser : rawUserList)
			UserUtility.setAgeOf(currentUser);
		return rawUserList;
		
	}
	
	public static User setAgeOf(User user){
		int age = DateUtility.calculateDifferenceYear(user.getBirthday());
		user.setAge(age);
		return user;
	}
	*/

	public static boolean isValidUser(DTOUser toCheck) {
		return (
				toCheck.getUsername() != null &&
				toCheck.getMail() != null &&
				StringUtilities.validateMail(toCheck.getMail()) &&
				toCheck.getBirthday() != null &&
				DateUtility.validateBirthday(toCheck.getBirthday()) &&
				toCheck.getIsFemale() != null 
				);
	}

	public static boolean isValidIdUser(DTOUser toCheck) {
		return toCheck.getIdUser()!=null;
	}

	public static boolean isValidUserInsert(DTOUser addedDTOUser) {
		return isValidUser(addedDTOUser) && !isValidIdUser(addedDTOUser);
	}
}
