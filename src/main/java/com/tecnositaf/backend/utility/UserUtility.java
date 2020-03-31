package com.tecnositaf.backend.utility;

import java.util.List;

import com.tecnositaf.backend.model.User;

public class UserUtility {

	public static List<User> setAge(List<User> rawUserList){
		
		for(User currentUser : rawUserList) {
			int ageToSet = DateUtility.calculateDifferenceYear(currentUser.getBirthDay());
			currentUser.setAge(ageToSet);
		}
		return rawUserList;
		
	}

	public static boolean checkUserValidity(User toCheck) {
		return (
				toCheck.getUsername() != null && 
				toCheck.getPassword() != null &&
				toCheck.getMail() != null &&
				StringUtilities.validateMail(toCheck.getMail()) &&
				toCheck.getBirthDay() != null &&
				DateUtility.validateBirthday(toCheck.getBirthDay()) &&
				toCheck.getIsFemale() != null 
				);
	}
}
