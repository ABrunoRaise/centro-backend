package com.tecnositaf.backend.controller.user;

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
public class AddSurveyEndpointTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wepAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wepAppContext).build();
    }

    private final String ENDPOINT_RESOURCE_BASE_URL = "http://localhost:8080/surveys";
    /**********     REQUEST json    **********/
    private final String deviceTestInsertRequestBodyJSON = "{" +
            "  \"ambientPressure\": 0," +
            "  \"ambientTemperature\": 0," +
            "  \"cpu\": 0," +
            "  \"deviceTemperature\": 0," +
            "  \"idDeviceFk\": \"deviceTest\"," +
            "  \"idSurvey\": null," +
            "  \"ram\": 0," +
            "  \"storageYears\": 0," +
            "  \"timestamp\": \"2012-09-10 00:00:00\"" +
            "}";
    private final String deviceNullInsertFailureForEmptyFieldRequestBodyJSON = "{" +
            "  \"ambientPressure\": 0," +
            "  \"ambientTemperature\": 0," +
            "  \"cpu\": 0," +
            "  \"deviceTemperature\": 0," +
            "  \"idDeviceFk\": null," +
            "  \"idSurvey\": null," +
            "  \"ram\": 0," +
            "  \"storageYears\": 0," +
            "  \"timestamp\": \"2012-09-10 00:00:00\"" +
            "}";

    /**********     RESPONSE json    **********/
    private final String addSurveyOnInitResponse = "{" +
            "  \"code\": 0," +
            "  \"message\": \"Success\"," +
            "  \"path\": \"http://localhost:8080/surveys\"," +
            "  \"numberOfSurveys\": 2," +
            "  \"surveyList\": [" +
            "    {" +
            "      \"idSurvey\": \"5e7a11e88a297d0cd94168a7\"," +
            "      \"idDeviceFk\": \"DeViCeTeSt2\"," +
            "      \"timestamp\": \"2020-03-24 14:58:00\"," +
            "      \"storageYears\": 0," +
            "      \"cpu\": 4.8," +
            "      \"ram\": 50.6," +
            "      \"deviceTemperature\": 4.9," +
            "      \"ambientTemperature\": 12.8," +
            "      \"ambientPressure\": 14.5" +
            "    }," +
            "    {" +
            "      \"idSurvey\": \"5e8b668f56c0fa7f05923d95\"," +
            "      \"idDeviceFk\": \"deviceTest\"," +
            "      \"timestamp\": \"2012-09-10 00:00:00\"," +
            "      \"storageYears\": 7," +
            "      \"cpu\": 0," +
            "      \"ram\": 0," +
            "      \"deviceTemperature\": 0," +
            "      \"ambientTemperature\": 0," +
            "      \"ambientPressure\": 0" +
            "    }" +
            "  ]" +
            "}";

    private final String addSurveyDeviceNullOnInitInvalidFieldResponseJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_INVALIDFIELD.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_INVALIDFIELD.getMessage() + "\"}";

    @Test
    public void successOnInit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( deviceTestInsertRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //response
                .andExpect(content().json( addSurveyOnInitResponse ))
                .andDo(print());
    }

    @Test
    public void failureForEmptyField() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( deviceNullInsertFailureForEmptyFieldRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                //response
                .andExpect(content().json( addSurveyDeviceNullOnInitInvalidFieldResponseJSON ))
                .andDo(print());
    }
}
