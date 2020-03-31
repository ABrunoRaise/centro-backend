package com.tecnositaf.backend.database;
/*
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tecnositaf.backend.model.Survey;


public class DatabaseFake {


	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private ArrayList<Survey> surveyTable = new ArrayList<>();
	private int idSurvey = 0;

	@PostConstruct
	private void initializeTable() {
		
		LocalDateTime currTime = LocalDateTime.now();
		Survey firstSurvey = new Survey(this.idSurvey++, 1, currTime, 4.8,50.6,4.9,12.8, 14.5);
		surveyTable.add(firstSurvey);
	
	}
	
	public ArrayList<Survey> getSurveyList(){
		
		log.info("IN GET SURVEY TABLE");
		return surveyTable;
	
	}
	
	public int addSurvey(Survey surveyToAdd) {
		
		log.info("IN ADD SURVEY");
		surveyToAdd.setIdSurvey(idSurvey++);
		if (surveyToAdd.getTimestamp() == null)
			surveyToAdd.setTimestamp(LocalDateTime.now());
		if(!surveyTable.add(surveyToAdd))
			return 0;
		return 1;
		
	}
	
	public Survey getSurveyById(int idSurvey) {
		log.info("IN GET SURVEY");
		Survey surveyToFind  = null;
		boolean find = false;
		for(int i = 0; i<surveyTable.size() && !find ; i++) {
			if (surveyTable.get(i).getIdSurvey()==idSurvey) {
				surveyToFind = surveyTable.get(i);
				find = true;
			}
		}
		return surveyToFind;
	}
	
	public int updateSurveybyId(Survey updatedSurvey){
		log.info("IN UPDATE SURVEY");
		if(updatedSurvey != null) {
			for(int i = 0; i<surveyTable.size() ; i++) {
				Survey currElem = surveyTable.get(i);
				if (currElem.getIdSurvey() == updatedSurvey.getIdSurvey()) {
					updatedSurvey.setTimestamp(currElem.getTimestamp());
					surveyTable.set(i, updatedSurvey);
					return 1;
				}
			}
		}
		return 0;
	}
	
	public int deleteSurveyById(int idSurvey){
		log.info("IN DELETE SURVEY");
		for(int i = 0; i<surveyTable.size() ; i++) {
			Survey currElem = surveyTable.get(i);
			if (currElem.getIdSurvey() == idSurvey) { 
				surveyTable.remove(currElem);
				return 1;
			}
		}
		return 0;
	}
	
	public ArrayList<Survey> getSurveysFromDevice(int idDevice){
		log.info("IN GET SURVEYS FROM DEVICE");
		ArrayList<Survey> toReturn = new ArrayList<Survey>();
		for (Survey survey : surveyTable) {
			if (survey.getIdDeviceFk() == idDevice) 
				toReturn.add(survey);
		}
		return toReturn;
	}
	
	public ArrayList<Survey> getSurveysFromDevice(int idDevice, LocalDateTime time){
		log.info("IN GET SURVEYS FROM DEVICE WITH TIMESTAMP");
		ArrayList<Survey> toReturn = new ArrayList<Survey>();
		for (Survey survey : surveyTable) {
			if (survey.getIdDeviceFk() == idDevice && survey.getTimestamp().compareTo(time) >= 0 ) 
				toReturn.add(survey);
		}
		return toReturn;
	}

	public Survey getFirstSurveyFromDevice(int idDevice) {
		log.info("IN GET FIRST SURVEY FROM DEVICE");
		for (Survey survey : surveyTable) {
			if (survey.getIdDeviceFk() == idDevice) 
				return survey;
		}
		return null;
	}	

}
*/