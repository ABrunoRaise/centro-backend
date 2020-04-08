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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class AddUserEndpointTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wepAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wepAppContext).build();
    }

    private final String ENDPOINT_RESOURCE_BASE_URL = "http://localhost:8080/users";

    /**********     REQUEST json    **********/
    private final String newUserInsertRequestBodyJSON = "{\n" +
            "  \"age\": 0,\n" +
            "  \"birthday\": \"1995-09-11 00:00:00\",\n" +
            "  \"isFemale\": true,\n" +
            "  \"mail\": \"newUser@gmail.com\",\n" +
            "  \"username\": \"newUser\"\n" +
            "}";

    private final String invalidFieldInsertRequestBodyJSON = "{\n" +
            "  \"age\": 0,\n" +
            "  \"birthday\": \"1995-09-11 00:00:00\",\n" +
            "  \"isFemale\": true,\n" +
            "  \"mail\": \"newUser...gmail.com\",\n" +
            "  \"username\": \"newUser\"\n" +
            "}";

    /**********     RESPONSE json    **********/

    private final String addSurveyDeviceNullOnInitInvalidFieldResponseJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_INVALIDFIELD.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_INVALIDFIELD.getMessage() + "\"}";

    @Test
    public void successOnInit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( newUserInsertRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //response
                .andExpect(jsonPath("$.code").exists())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.path").exists())
                .andExpect(jsonPath("$.path").value("http://localhost:8080/users"))
                .andExpect(jsonPath("$.numberOfUser").exists())
                .andExpect(jsonPath("$.numberOfUser").value(2))
                .andExpect(jsonPath("$.userList").exists())
                .andExpect(jsonPath("$.userList").isArray())
                .andExpect(jsonPath("$.userList", hasSize(2)))
                .andDo(print());
    }

    @Test
    public void failureForEmptyField() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( invalidFieldInsertRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                //response
                .andExpect(content().json( addSurveyDeviceNullOnInitInvalidFieldResponseJSON ))
                .andDo(print());
    }
}
