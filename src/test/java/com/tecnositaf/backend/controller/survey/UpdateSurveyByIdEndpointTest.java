package com.tecnositaf.backend.controller.survey;

import com.tecnositaf.backend.CentroBackendApplication;
import com.tecnositaf.backend.enumeration.ResponseErrorEnum;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UpdateSurveyByIdEndpointTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wepAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wepAppContext).build();
    }

    private final String ENDPOINT_RESOURCE_BASE_URL = "http://localhost:8080/surveys";

    /**********     REQUEST json    **********/
    private final String deviceTestUpdatedUpdateRequestBodyJSON = "{\n" +
            "    \"idSurvey\": \"5e8d8cfdf614ec1938287fda\",\n" +
            "    \"idDeviceFk\": \"deviceTestUpdated\",\n" +
            "    \"timestamp\": \"2020-03-24 14:58:00\",\n" +
            "    \"storageYears\": 0,\n" +
            "    \"cpu\": 4.8,\n" +
            "    \"ram\": 50.6,\n" +
            "    \"deviceTemperature\": 4.9,\n" +
            "    \"ambientTemperature\": 12.8,\n" +
            "    \"ambientPressure\": 14.5\n" +
            "}";

    private final String surveyNullUpdateRequestBodyJSON = "{\n" +
            "    \"idSurvey\" : null,"+
            "    \"idDeviceFk\": \"deviceTestUpdated\",\n" +
            "    \"timestamp\": \"2020-03-24 14:58:00\",\n" +
            "    \"storageYears\": 0,\n" +
            "    \"cpu\": 4.8,\n" +
            "    \"ram\": 50.6,\n" +
            "    \"deviceTemperature\": 4.9,\n" +
            "    \"ambientTemperature\": 12.8,\n" +
            "    \"ambientPressure\": 14.5\n" +
            "}";

    private final String invalidFieldUpdateRequestBodyJSON = "{\n" +
            "    \"idSurvey\": \"5e8d8cfdf614ec1938287fda\",\n" +
            "    \"idDeviceFk\": null,\n" +
            "    \"timestamp\": \"2020-03-24 14:58:00\",\n" +
            "    \"storageYears\": 0,\n" +
            "    \"cpu\": 4.8,\n" +
            "    \"ram\": 50.6,\n" +
            "    \"deviceTemperature\": 4.9,\n" +
            "    \"ambientTemperature\": 12.8,\n" +
            "    \"ambientPressure\": 14.5\n" +
            "}";
    /**********     RESPONSE json    **********/
    private final String updateSurveyByIdOnInitResponse = "{" +
            "  \"code\": 0," +
            "  \"message\": \"Success\"," +
            "  \"path\": \"http://localhost:8080/surveys\"," +
            "  \"numberOfSurveys\": 1," +
            "  \"surveyList\": [" +
            "    {" +
            "      \"idSurvey\": \"5e8d8cfdf614ec1938287fda\"," +
            "      \"idDeviceFk\": \"deviceTestUpdated\"," +
            "      \"timestamp\": \"2020-03-24 14:58:00\"," +
            "      \"storageYears\": 0," +
            "      \"cpu\": 4.8," +
            "      \"ram\": 50.6," +
            "      \"deviceTemperature\": 4.9," +
            "      \"ambientTemperature\": 12.8," +
            "      \"ambientPressure\": 14.5" +
            "    }" +
            "  ]" +
            "}";
    //To restore db DeViCeTeSt2

    private final String updateSurveySurveyNullOnInitUnauthorizedJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_INVALIDSURVEYFIELD.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_INVALIDSURVEYFIELD.getMessage() + "\"}";

    private final String updateSurveyDeviceNullOnInitInvalidFieldResponseJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_INVALIDFIELD.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_INVALIDFIELD.getMessage() + "\"}";

    @Test
    public void successOnInit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( deviceTestUpdatedUpdateRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //response
                .andExpect(content().json( updateSurveyByIdOnInitResponse ))
                .andDo(print());
    }

    @Test
    public void failureForEmptySurvey() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( surveyNullUpdateRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                //response
                .andExpect(content().json( updateSurveySurveyNullOnInitUnauthorizedJSON ))
                .andDo(print());
    }

    @Test
    public void failureForEmptyField() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( invalidFieldUpdateRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                //response
                .andExpect(content().json( updateSurveyDeviceNullOnInitInvalidFieldResponseJSON ))
                .andDo(print());
    }
}
