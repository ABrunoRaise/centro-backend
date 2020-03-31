package com.tecnositaf.backend.response.surveyResponse;

import java.util.List;

import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.response.Response;

public class GetSurveysByStorageYears extends Response{

	

	int storageYears;
	int numberOfSurveys;
	List<Survey> surveyList;
	
	public GetSurveysByStorageYears(int code, String message, String path, 
			int storageYears , List<Survey> surveyList) {
		super(code, message, path);
		this.storageYears = storageYears;
		this.surveyList = surveyList;
		this.numberOfSurveys = surveyList.size();
	}
	
	public GetSurveysByStorageYears(String path, int storageYears , List<Survey> surveyList) {
		super(0, "Success", path);
		this.storageYears = storageYears;
		this.surveyList = surveyList;
		this.numberOfSurveys = surveyList.size();
	}

	public GetSurveysByStorageYears(int code, String message, String path, 
			int storageYears , List<Survey> surveyList, int numberOfSurveys) {
		super(code, message, path);
		this.storageYears = storageYears;
		this.surveyList = surveyList;
		this.numberOfSurveys = numberOfSurveys;
	}
	
	public int getStorageYears() {
		return storageYears;
	}

	public void setStorageYears(int storageYears) {
		this.storageYears = storageYears;
	}

	public List<Survey> getSurveys() {
		return surveyList;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveyList = surveys;
	}

	public int getNumberOfSurveys() {
		return numberOfSurveys;
	}

	public void setNumberOfSurveys(int numberOfSurveys) {
		this.numberOfSurveys = numberOfSurveys;
	}
	
	
}
