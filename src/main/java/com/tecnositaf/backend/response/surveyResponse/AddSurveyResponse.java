package com.tecnositaf.backend.response.surveyResponse;

import java.util.List;

import com.tecnositaf.backend.dto.DTOSurvey;
import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.response.Response;

public class AddSurveyResponse extends Response{
	
	int numberOfSurveys;
	List<DTOSurvey> surveyList;
	
	public AddSurveyResponse(int code, String message, String path, List<Survey> surveyList) {
		super(code, message, path);
		surveyList.forEach(survey ->
				this.surveyList.add(survey.toDtoSurvey())
		);
		this.numberOfSurveys = surveyList.size();
	}
	
	public AddSurveyResponse(String path, List<Survey> surveyList) {
		super(0,"Success",path);
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
