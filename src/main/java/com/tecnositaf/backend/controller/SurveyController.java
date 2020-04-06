package com.tecnositaf.backend.controller;

import java.time.LocalDateTime;
import java.util.List;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import com.tecnositaf.backend.dto.DTOSurvey;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import com.tecnositaf.backend.exception.CustomException;
import com.tecnositaf.backend.model.Survey;
import com.tecnositaf.backend.response.*;
import com.tecnositaf.backend.response.surveyResponse.AddSurveyResponse;
import com.tecnositaf.backend.response.surveyResponse.GetSurveyByIdResponse;
import com.tecnositaf.backend.response.surveyResponse.GetSurveysByDeviceResponse;
import com.tecnositaf.backend.response.surveyResponse.GetSurveysByStorageYears;
import com.tecnositaf.backend.response.surveyResponse.GetTableResponse;
import com.tecnositaf.backend.response.surveyResponse.RemoveSurveyByIdResponse;
import com.tecnositaf.backend.response.surveyResponse.UpdateSurveyByIdResponse;
import com.tecnositaf.backend.service.SurveyService;
import com.tecnositaf.backend.utility.SurveyUtility;
import com.tecnositaf.backend.utility.DateUtility;

import javax.validation.Valid;

@RequestMapping("/surveys")
@RestController
public class SurveyController {
	
	// private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SurveyService surveyService;
	
	@GetMapping
	public ResponseEntity<GetTableResponse> getTable(){
		
		List<Survey> surveyList = surveyService.getSurveyList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new GetTableResponse( 
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(), 
				surveyList
			)
		);
		
	}
	
	@PostMapping
	public ResponseEntity<AddSurveyResponse> addSurvey(
			@RequestBody
			@ApiParam(value = "JSON format input, idSurvey not required.") DTOSurvey addedDTOSurvey) {
		if (!SurveyUtility.isValidSurvey(addedDTOSurvey))
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDFIELD, HttpStatus.UNAUTHORIZED);
		Survey toAddInDbSurvey = addedDTOSurvey.toSurvey();
		surveyService.addSurvey(toAddInDbSurvey);
		List<Survey> updatedSurveyList = surveyService.getSurveyList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new AddSurveyResponse( 
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(), 
				updatedSurveyList
			));
		
	}
	
	@PutMapping
	public ResponseEntity<UpdateSurveyByIdResponse> updateSurveyById(
			@RequestBody DTOSurvey updatedDTOSurvey){
		if(!SurveyUtility.isValidIdSurvey(updatedDTOSurvey))
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDSURVEYFIELD, HttpStatus.UNAUTHORIZED);
		if (!SurveyUtility.isValidSurvey(updatedDTOSurvey))
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDFIELD,HttpStatus.BAD_REQUEST);
		Survey updatedSurvey = updatedDTOSurvey.toSurvey();
		surveyService.updateSurveyById(updatedSurvey); 
		List<Survey> updatedSurveyList = surveyService.getSurveyList();
		return ResponseEntity.status(HttpStatus.OK).body(
			new UpdateSurveyByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				updatedSurveyList				
			));
		
	}
	
	@GetMapping(path = "/devices/{idDevice}")
	public ResponseEntity<GetSurveysByDeviceResponse> getSurveysByDevice(
			@PathVariable String idDevice, 
			@RequestParam(required = false) 
			@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime timestamp){
		
		// Check IdDevice con deviceService.getDeviceByIdDevice(idDevice)
		List<Survey> surveysFromDevice;
		if (timestamp == null) 
			surveysFromDevice = surveyService.getSurveysFromDevice(idDevice);
		else 		
			surveysFromDevice = surveyService.getSurveysFromDevice(idDevice, timestamp); 
		return ResponseEntity.status(HttpStatus.OK).body(
			new GetSurveysByDeviceResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				surveysFromDevice
			));
		
	}
	
	@GetMapping(path = "/storageYears/{storageYear}")
	public ResponseEntity<GetSurveysByStorageYears> getSurveysByStorageYear(@PathVariable int storageYears) {
		
		if(!DateUtility.checkYearValidity(storageYears))
			throw new CustomException(ResponseErrorEnum.ERR_INVALIDPERIOD,HttpStatus.BAD_REQUEST);
		List<Survey> surveysByStorageYears = surveyService.getSurveysByStorageYears(storageYears);
		return ResponseEntity.status(HttpStatus.OK).body(
			new GetSurveysByStorageYears(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				storageYears,
				surveysByStorageYears
			));
		
	}
	
	// single Survey functions
	
	@GetMapping(path = "/{idSurvey}")
	public ResponseEntity<GetSurveyByIdResponse> getSurveyById(@PathVariable String idSurvey) {
		
		Survey surveyToReturn = surveyService.getSurveyById(idSurvey);
		return  ResponseEntity.status(HttpStatus.OK).body(
			new GetSurveyByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				surveyToReturn
			));

	}
	
	@DeleteMapping(path = "/{idSurvey}")
	public ResponseEntity<RemoveSurveyByIdResponse> removeSurveyById(@PathVariable String idSurvey) {
		
		Survey surveyToDelete = surveyService.getSurveyById(idSurvey);
		surveyService.deleteSurvey(surveyToDelete);
		List<Survey> updatedSurveyList = surveyService.getSurveyList();  
		return ResponseEntity.status(HttpStatus.OK).body(
			new RemoveSurveyByIdResponse(
				ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
				updatedSurveyList
			));
		
	}
	
}
