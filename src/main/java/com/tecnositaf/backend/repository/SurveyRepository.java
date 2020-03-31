package com.tecnositaf.backend.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tecnositaf.backend.model.Survey;

@Repository
public interface SurveyRepository extends MongoRepository<Survey,String>{
	
	@Query("{'idDeviceFk': ?0}")
	List<Survey> getSurveyByIdDevice(String idDevice);
	@Query("{'idDeviceFk': ?0, 'timestamp': { $gte : ?1 }}")
	List<Survey> getSurveyByIdDevice(String idDevice, LocalDateTime timestamp);
	
}
