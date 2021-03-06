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
import com.tecnositaf.backend.utilities.DateUtility;

@Service
public class SurveyService {

	@Autowired
	SurveyRepository surveyRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public List<Survey> getSurveyList() {
		
		log.info("In get survey list");
		return surveyRepository.findAll();
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
		return surveyRepository.getSurveyByIdDevice(idDevice);

	}

	public List<Survey> getSurveysFromDevice(String idDevice, LocalDateTime timestamp) {
		
		log.info("In get surveys from device with timestamp");
		return surveyRepository.getSurveyByIdDevice(idDevice, timestamp);

	}

	
	public List<Survey> getSurveysByStorageYears(int storageYears) {
		
		log.info("In get surveys from storageYears");
		List<Survey> surveysToFilter = getSurveyList();
		List<Survey> surveysFiltered;
		surveysFiltered = surveysToFilter.stream()
								 .filter(currentSurvey -> DateUtility.calculateDifferenceYear(currentSurvey.getTimestamp()) <= storageYears)
								 .collect(Collectors.toList());
		return surveysFiltered;
		
	}
	
	
	public Survey getSurveyById(String idSurvey) {
		
		log.info("In get survey by id");
		return surveyRepository.findById(idSurvey).orElseThrow(
				() -> new CustomException(ResponseErrorEnum.ERR_MISSINGRESOURCE,HttpStatus.UNAUTHORIZED));

	}
	
	public void deleteSurvey(Survey surveyToDelete) {
		
		log.info("In delete survey");
		surveyRepository.delete(surveyToDelete);
		
	}
	
}
