package com.tecnositaf.backend.utility;

import java.util.List;

import com.tecnositaf.backend.dto.DTOSurvey;
import com.tecnositaf.backend.model.Survey;

public class SurveyUtility {
	
	// static Logger log = LoggerFactory.getLogger(Common.class);

	/*
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
	*/


	public static boolean isValidSurvey(DTOSurvey toCheck) {
		return (
				toCheck.getIdDeviceFk() != null &&
						toCheck.getCpu() != null &&
						toCheck.getRam() != null &&
						toCheck.getDeviceTemperature() != null &&
						toCheck.getAmbientTemperature() != null &&
						toCheck.getAmbientPressure() != null
		);
	}

	public static boolean isValidIdSurvey(DTOSurvey toCheck) {
		return toCheck.getIdSurvey() != null ;
	}

    public static boolean isValidSurveyForInsert(DTOSurvey addedDTOSurvey) {
		return isValidSurvey(addedDTOSurvey) && !isValidIdSurvey(addedDTOSurvey);
    }
}
