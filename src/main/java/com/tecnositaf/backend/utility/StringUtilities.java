package com.tecnositaf.backend.utility;

import java.util.regex.Pattern;

public class StringUtilities {

	public static boolean validateMail(String mailToValidate) {
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
							"[a-zA-Z0-9_+&*-]+)*@" + 
							"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
							"A-Z]{2,7}$"; 
		           
		Pattern pat = Pattern.compile(emailRegex); 
		if (mailToValidate == null) 
			return false; 	
		return pat.matcher(mailToValidate).matches(); 
		
	}
}
