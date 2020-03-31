package com.tecnositaf.backend.response.surveyResponse;

import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.response.Response;

public class GetSurveyByIdResponse extends Response{

	Survey survey;
	
	public GetSurveyByIdResponse(int code, String message, String path, Survey survey) {
		super(code, message, path);
		this.survey = survey;
	}

	public GetSurveyByIdResponse(String path, Survey survey) {
		super(0, "Success", path);
		this.survey = survey;
	}
	
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}	
	
}
