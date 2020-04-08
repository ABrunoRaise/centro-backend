package com.tecnositaf.backend.utilities;

import com.tecnositaf.backend.dto.DTOUser;

public class UserUtility {

	public static boolean isValidUser(DTOUser toCheck) {
		return (
				toCheck.getUsername() != null &&
				toCheck.getMail() != null &&
				StringUtility.validateMail(toCheck.getMail()) &&
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
