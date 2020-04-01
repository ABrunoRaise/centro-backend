package com.tecnositaf.backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import com.tecnositaf.backend.exception.CustomException;
import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.repository.SurveyRepository;
import com.tecnositaf.backend.utility.DateUtility;
import com.tecnositaf.backend.utility.SurveyUtility;

@Service
public class SurveyService {

	@Autowired
	SurveyRepository surveyRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public List<Survey> getSurveyList() {
		
		log.info("In get survey list");
		List<Survey> rawSurveyList = surveyRepository.findAll();
		return SurveyUtility.setStorageYear(rawSurveyList);
		
	}
	
	public Survey addSurvey(Survey addedSurvey) {
		
		log.info("In add survey");
		if(addedSurvey.getTimestamp() == null)
			addedSurvey.setTimestamp(LocalDateTime.now());
		return surveyRepository.insert(addedSurvey);

	}


	public Survey updateSurveyById(Survey updatedSurvey) {
		
		log.info("In update survey");
		Survey surveyToUpdate = surveyRepository.findById(updatedSurvey.getIdSurvey()).orElseThrow(
									() -> new CustomException(ResponseErrorEnum.ERR_MISSINGRESOURCE, HttpStatus.UNAUTHORIZED));
		updatedSurvey.setTimestamp(surveyToUpdate.getTimestamp());
		return surveyRepository.save(updatedSurvey);
		
	}
	
	public List<Survey> getSurveysFromDevice(String idDevice) {
		
		log.info("In get surveys from device");
		List<Survey> rawSurveyList = surveyRepository.getSurveyByIdDevice(idDevice);
		return SurveyUtility.setStorageYear(rawSurveyList);
		
	}

	public List<Survey> getSurveysFromDevice(String idDevice, LocalDateTime timestamp) {
		
		log.info("In get surveys from device with timestamp");
		List<Survey> rawSurveyList = surveyRepository.getSurveyByIdDevice(idDevice, timestamp);
		return SurveyUtility.setStorageYear(rawSurveyList);
		
	}

	
	public List<Survey> getSurveysByStorageYears(int storageYears) {
		
		log.info("In get surveys from storageYears");
		List<Survey> surveysToFilter = getSurveyList();
		List<Survey> surveysFiltered;
		surveysFiltered = surveysToFilter.stream()
								 .filter(currentSurvey -> currentSurvey.getStorageYears() <= storageYears)
								 .collect(Collectors.toList());
		return surveysFiltered;
		
	}
	
	
	public Survey getSurveyById(String idSurvey) {
		
		log.info("In get survey by id");
		Survey surveyFound = surveyRepository.findById(idSurvey).orElseThrow(
								() -> new CustomException(ResponseErrorEnum.ERR_MISSINGRESOURCE,HttpStatus.UNAUTHORIZED));
		int storageYears = DateUtility.calculateDifferenceYear(surveyFound.getTimestamp());
		surveyFound.setStorageYears(storageYears);
		return surveyFound;

	}
	
	public void deleteSurvey(Survey surveyToDelete) {
		
		log.info("In delete survey");
		surveyRepository.delete(surveyToDelete);
		
	}
	
}
