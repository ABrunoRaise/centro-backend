package com.tecnositaf.backend.utilities;

import com.tecnositaf.backend.dto.DTOSurvey;

public class SurveyUtility {

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
