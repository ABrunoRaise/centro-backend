package com.tecnositaf.backend.response.surveyResponse;

import java.util.List;

import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.response.Response;

public class GetTableResponse extends Response{
	
	int numberOfSurveys;
	List<Survey> surveyList;
	
	public GetTableResponse(int code, String message, String path, List<Survey> surveyList) {
		super(code, message, path);
		this.surveyList = surveyList;
		this.numberOfSurveys = surveyList.size();
	}
	
	public GetTableResponse(String path, List<Survey> surveyList) {
		super(0,"Success",path);
		this.surveyList = surveyList;
		this.numberOfSurveys = surveyList.size();
	}

	public List<Survey> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(List<Survey> surveyList) {
		this.surveyList = surveyList;
	}

	public int getNumberOfSurveys() {
		return numberOfSurveys;
	}

	public void setNumberOfSurveys(int numberOfSurveys) {
		this.numberOfSurveys = numberOfSurveys;
	}
	
	
	
	
	
}
