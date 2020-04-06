package com.tecnositaf.backend.controller.user;
import com.tecnositaf.backend.CentroBackendApplication;
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
public class GetSurveysEndpointTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wepAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wepAppContext).build();
    }

    private final String ENDPOINT_RESOURCE_BASE_URL = "http://localhost:8080/surveys";

    private final String getSurveysOnInitResponse = "{" +
            "  \"code\": 0," +
            "  \"message\": \"Success\"," +
            "  \"path\": \"http://localhost:8080/surveys\"," +
            "  \"numberOfSurveys\": 1," +
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
            "    }" +
            "  ]" +
            "}";

    @Test
    public void successOnInit() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_RESOURCE_BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //response
                .andExpect(content().json(getSurveysOnInitResponse))
                .andDo(print());
    }

}
