package com.tecnositaf.backend.utility;

import java.util.List;

import com.tecnositaf.backend.model.Survey;

public class SurveyUtility {
	
	// static Logger log = LoggerFactory.getLogger(Common.class);
	
	public static boolean checkSurveyValidity(Survey toCheck) {
		return (
				toCheck.getIdDeviceFk() != null && 
				toCheck.getCpu() != null &&
				toCheck.getRam() != null &&
				toCheck.getDeviceTemperature() != null &&
				toCheck.getAmbientTemperature() != null &&
				toCheck.getAmbientPressure() != null
				);
	}
		 
	public static boolean checkSurveyIDValidity(Survey toCheck) {
		return toCheck.getIdSurvey() != null ;
	}
	
	public static List<Survey> setStorageYear(List<Survey> rawSurveyList){
		
		for(Survey currentSurvey : rawSurveyList) {
			int storageYearsToSet = DateUtility.calculateDifferenceYear(currentSurvey.getTimestamp());
			currentSurvey.setStorageYears(storageYearsToSet);
		}
		return rawSurveyList;
		
	}
	
}
