package com.tecnositaf.backend.utility;

import java.util.List;

import com.tecnositaf.backend.model.User;

public class UserUtility {

	public static List<User> setAge(List<User> rawUserList){
		
		for(User currentUser : rawUserList) {
			int ageToSet = DateUtility.calculateDifferenceYear(currentUser.getBirthday());
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
				toCheck.getBirthday() != null &&
				DateUtility.validateBirthday(toCheck.getBirthday()) &&
				toCheck.getIsFemale() != null 
				);
	}

	public static boolean checkUserIDValidity(User toCheck) {
		return toCheck.getIdUser()!=null;
	}
}
