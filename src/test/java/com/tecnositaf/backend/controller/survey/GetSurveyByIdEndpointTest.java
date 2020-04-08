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
public class GetSurveyByIdEndpointTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wepAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wepAppContext).build();
    }

    private final String ENDPOINT_RESOURCE_BASE_URL = "http://localhost:8080/surveys/5e8d8cfdf614ec1938287fda";

    private final String ENDPOINT_ERROR_BASE_URL = "http://localhost:8080/surveys/notInList";

    private final String getSurveyByIdOnInitResponse = "{\n" +
            "    \"code\": 0,\n" +
            "    \"message\": \"Success\",\n" +
            "    \"path\": \"http://localhost:8080/surveys/5e8d8cfdf614ec1938287fda\",\n" +
            "    \"survey\": {\n" +
            "        \"idSurvey\": \"5e8d8cfdf614ec1938287fda\",\n" +
            "        \"idDeviceFk\": \"DeViCeTeSt2\",\n" +
            "        \"timestamp\": \"2020-03-24 14:58:00\",\n" +
            "        \"storageYears\": 0,\n" +
            "        \"cpu\": 4.8,\n" +
            "        \"ram\": 50.6,\n" +
            "        \"deviceTemperature\": 4.9,\n" +
            "        \"ambientTemperature\": 12.8,\n" +
            "        \"ambientPressure\": 14.5\n" +
            "    }\n" +
            "}";

    private final String getSurveysByIdOnInitInvalidSurveyResponseJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_MISSINGRESOURCE.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_MISSINGRESOURCE.getMessage() + "\"}";


    @Test
    public void successOnInit() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_RESOURCE_BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //response
                .andExpect(content().json(getSurveyByIdOnInitResponse))
                .andDo(print());
    }

    @Test
    public void invalidSurveyOnInit() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_ERROR_BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //response
                .andExpect(content().json(getSurveysByIdOnInitInvalidSurveyResponseJSON))
                .andDo(print());
    }
}
