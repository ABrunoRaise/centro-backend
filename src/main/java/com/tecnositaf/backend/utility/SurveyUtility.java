package com.tecnositaf.backend.utility;

import java.util.List;

import com.tecnositaf.backend.model.Survey;

public class SurveyUtility {
	
	// static Logger log = LoggerFactory.getLogger(Common.class);

	
	public static List<Survey> setStorageYearsOf(List<Survey> rawSurveyList){
		
		for(Survey currentSurvey : rawSurveyList) {
			setStorageYearsOf(currentSurvey);
		}
		return rawSurveyList;
		
	}

	public static Survey setStorageYearsOf(Survey surveyFound) {
		int storageYearsToSet = DateUtility.calculateDifferenceYear(surveyFound.getTimestamp());
		surveyFound.setStorageYears(storageYearsToSet);
		return surveyFound;
	}


	public static boolean isValidSurvey(Survey toCheck) {
		return (
				toCheck.getIdDeviceFk() != null &&
						toCheck.getCpu() != null &&
						toCheck.getRam() != null &&
						toCheck.getDeviceTemperature() != null &&
						toCheck.getAmbientTemperature() != null &&
						toCheck.getAmbientPressure() != null
		);
	}

	public static boolean isValidIdSurvey(Survey toCheck) {
		return toCheck.getIdSurvey() != null ;
	}
}
