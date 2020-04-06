package com.tecnositaf.backend.response.surveyResponse;

import java.util.ArrayList;
import java.util.List;

import com.tecnositaf.backend.dto.DTOSurvey;
import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.response.Response;

public class GetSurveysByStorageYears extends Response{

	

	int storageYears;
	int numberOfSurveys;
	List<DTOSurvey> surveyList;
	
	public GetSurveysByStorageYears(int code, String message, String path, 
			int storageYears , List<Survey> surveyList) {
		super(code, message, path);
		this.storageYears = storageYears;
		this.surveyList = new ArrayList<>();
		surveyList.forEach(survey ->
				this.surveyList.add(survey.toDtoSurvey())
		);
		this.numberOfSurveys = surveyList.size();
	}
	
	public GetSurveysByStorageYears(String path, int storageYears , List<Survey> surveyList) {
		super(0, "Success", path);
		this.storageYears = storageYears;
		this.surveyList = new ArrayList<>();
		surveyList.forEach(survey ->
				this.surveyList.add(survey.toDtoSurvey())
		);
		this.numberOfSurveys = surveyList.size();
	}
	
	public int getStorageYears() {
		return storageYears;
	}

	public void setStorageYears(int storageYears) {
		this.storageYears = storageYears;
	}

	public List<DTOSurvey> getSurveys() {
		return surveyList;
	}

	public void setSurveys(List<DTOSurvey> surveys) {
		this.surveyList = surveys;
	}

	public int getNumberOfSurveys() {
		return numberOfSurveys;
	}

	public void setNumberOfSurveys(int numberOfSurveys) {
		this.numberOfSurveys = numberOfSurveys;
	}
	
	
}
