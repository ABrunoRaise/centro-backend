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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetSurveysByStorageYearEndpointTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wepAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wepAppContext).build();
    }

    private final String ENDPOINT_RESOURCE_BASE_URL = "http://localhost:8080/surveys/storageYears/1";

    private final String ENDPOINT_ERROR_BASE_URL = "http://localhost:8080/surveys/storageYears/0";

    /**********     RESPONSE json    **********/
    private final String getSurveysByStorageYearOnInitResponse = "{" +
            "  \"code\": 0," +
            "  \"message\": \"Success\"," +
            "  \"path\": \"http://localhost:8080/surveys/storageYears/1\"," +
            "  \"numberOfSurveys\": 1," +
            "  \"surveyList\": [" +
            "    {" +
            "      \"idSurvey\": \"5e8d8cfdf614ec1938287fda\"," +
            "      \"idDeviceFk\": \"DeViCeTeSt2\"," +
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

    private final String getSurveysByStorageYearOnInitInvalidStorageYearsResponseJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_INVALIDPERIOD.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_INVALIDPERIOD.getMessage() + "\"}";

    @Test
    public void successOnInit() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_RESOURCE_BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //response
                .andExpect(content().json(getSurveysByStorageYearOnInitResponse))
                .andDo(print());
    }

    @Test
    public void invalidStorageYearsOnInit() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_ERROR_BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //response
                .andExpect(content().json(getSurveysByStorageYearOnInitInvalidStorageYearsResponseJSON))
                .andDo(print());
    }
}
