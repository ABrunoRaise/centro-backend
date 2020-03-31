package com.tecnositaf.backend.utility;

import java.time.LocalDateTime;

public class DateUtility {

	public static int calculateDifferenceYear(LocalDateTime surveyTimestamp) {
		
		LocalDateTime currentTime = LocalDateTime.now();
		int storageYear = currentTime.getYear()-surveyTimestamp.getYear();
		if (currentTime.getMonthValue() < surveyTimestamp.getMonthValue())
			storageYear--;
		else if(currentTime.getMonthValue() == surveyTimestamp.getMonthValue())
			if(currentTime.getDayOfMonth() < surveyTimestamp.getDayOfMonth())
				storageYear--;
		return storageYear;
		
	}

	public static boolean checkYearValidity(int storageYear) {
		return storageYear > 0;
	}

	public static boolean validateBirthday(LocalDateTime birthday) {
		return (birthday.compareTo(LocalDateTime.now()) < 0);
	}

}
