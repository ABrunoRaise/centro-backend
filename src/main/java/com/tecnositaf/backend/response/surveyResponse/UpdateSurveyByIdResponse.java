package com.tecnositaf.backend.response.surveyResponse;

import java.util.ArrayList;
import java.util.List;

import com.tecnositaf.backend.dto.DTOSurvey;
import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.response.Response;

public class UpdateSurveyByIdResponse extends Response {

	int numberOfSurveys;
	List<DTOSurvey> surveyList;
	
	public UpdateSurveyByIdResponse(int code, String message, String path, List<Survey> surveyList) {
		super(code, message, path);
		this.surveyList = new ArrayList<>();
		surveyList.forEach(survey ->
				this.surveyList.add(survey.toDtoSurvey())
		);
		this.numberOfSurveys = surveyList.size();
	}
	
	public UpdateSurveyByIdResponse(String path, List<Survey> surveyList) {
		super(0,"Success",path);
		this.surveyList = new ArrayList<>();
		surveyList.forEach(survey ->
				this.surveyList.add(survey.toDtoSurvey())
		);
		this.numberOfSurveys = surveyList.size();
	}

	public int getNumberOfSurveys() {
		return numberOfSurveys;
	}

	public void setNumberOfSurveys(int numberOfSurveys) {
		this.numberOfSurveys = numberOfSurveys;
	}

	public List<DTOSurvey> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(List<DTOSurvey> surveyList) {
		this.surveyList = surveyList;
	}
	
	
}
