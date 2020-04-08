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

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
    private final String deviceTestInsertRequestBodyJSON = "{\n" +
            "  \"ambientPressure\": 0,\n" +
            "  \"ambientTemperature\": 0,\n" +
            "  \"cpu\": 0,\n" +
            "  \"deviceTemperature\": 0,\n" +
            "  \"idDeviceFk\": \"deviceTest\",\n" +
            "  \"idSurvey\": null,\n" +
            "  \"ram\": 0,\n" +
            "  \"storageYears\": 0,\n" +
            "  \"timestamp\": \"2012-09-10 00:00:00\"\n" +
            "}";
    private final String deviceNullInsertFailureForEmptyFieldRequestBodyJSON = "{\n" +
            "  \"ambientPressure\": 0,\n" +
            "  \"ambientTemperature\": 0,\n" +
            "  \"cpu\": 0,\n" +
            "  \"deviceTemperature\": 0,\n" +
            "  \"idDeviceFk\": null,\n" +
            "  \"idSurvey\": null,\n" +
            "  \"ram\": 0,\n" +
            "  \"storageYears\": 0,\n" +
            "  \"timestamp\": \"2012-09-10 00:00:00\"\n" +
            "}";

    /**********     RESPONSE json    **********/

    private final String addSurveyDeviceNullOnInitInvalidFieldResponseJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_INVALIDFIELD.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_INVALIDFIELD.getMessage() + "\"}";

    @Test
    public void successOnInit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( deviceTestInsertRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //response
                .andExpect(jsonPath("$.code").exists())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.path").exists())
                .andExpect(jsonPath("$.path").value("http://localhost:8080/surveys"))
                .andExpect(jsonPath("$.numberOfSurveys").exists())
                .andExpect(jsonPath("$.numberOfSurveys").value(2))
                .andExpect(jsonPath("$.surveyList").exists())
                .andExpect(jsonPath("$.surveyList").isArray())
                .andExpect(jsonPath("$.surveyList", hasSize(2)))
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
