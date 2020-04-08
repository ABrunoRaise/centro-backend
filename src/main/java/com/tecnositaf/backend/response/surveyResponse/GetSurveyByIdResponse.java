package com.tecnositaf.backend.response.surveyResponse;

import com.tecnositaf.backend.dto.DTOSurvey;
import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.response.Response;

public class GetSurveyByIdResponse extends Response{

	DTOSurvey survey;
	
	public GetSurveyByIdResponse(int code, String message, String path, Survey survey) {
		super(code, message, path);
		this.survey = survey.toDtoSurvey();
	}

	public GetSurveyByIdResponse(String path, Survey survey) {
		super(0, "Success", path);
		this.survey = survey.toDtoSurvey();
	}
	
	public DTOSurvey getSurvey() {
		return survey;
	}

	public void setSurvey(DTOSurvey survey) {
		this.survey = survey;
	}	
	
}
