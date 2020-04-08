package com.tecnositaf.backend.utilities;

import com.tecnositaf.backend.CentroBackendApplication;
import com.tecnositaf.backend.dto.DTOSurvey;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SurveyUtilityTest {

    @Test
    public void TestSuccessIsValidSurvey(){
        DTOSurvey dtoSurveyToValidate = new DTOSurvey(
            "idSurvey",
            "idDeviceSurvey",
            LocalDateTime.now(),
            0,
            0.0,
            0.0,
            0.0,
            0.0,
            0.0
        );

        assertTrue(SurveyUtility.isValidSurvey(dtoSurveyToValidate));
    }

    @Test
    public void TestFailureIsValidSurvey(){
        DTOSurvey dtoSurveyToValidate = new DTOSurvey(
                "idSurvey",
                null,
                LocalDateTime.now(),
                0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0
        );

        assertFalse(SurveyUtility.isValidSurvey(dtoSurveyToValidate));
    }

    @Test
    public void TestSuccessIsValidIdSurvey(){
        DTOSurvey dtoSurveyToValidate = new DTOSurvey(
                "idSurvey",
                "idDeviceSurvey",
                LocalDateTime.now(),
                0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0
        );

        assertTrue(SurveyUtility.isValidIdSurvey(dtoSurveyToValidate));
    }
    @Test
    public void TestFailureIsValidIdSurvey(){
        DTOSurvey dtoSurveyToValidate = new DTOSurvey(
                null,
                "idDeviceSurvey",
                LocalDateTime.now(),
                0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0
        );

        assertFalse(SurveyUtility.isValidIdSurvey(dtoSurveyToValidate));
    }

}
