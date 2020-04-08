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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class UpdateUserEndpointTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wepAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wepAppContext).build();
    }

    private final String ENDPOINT_RESOURCE_BASE_URL = "http://localhost:8080/users";

    /**********     REQUEST json    **********/
    private final String usernameNewdUpdateRequestBodyJSON = "{\n" +
            "      \"idUser\": 10,\n" +
            "      \"username\": \"usernameNew\",\n" +
            "      \"mail\": \"string@alice.it\",\n" +
            "      \"birthday\": \"2000-09-11 00:00:00\",\n" +
            "      \"age\": 19,\n" +
            "      \"isFemale\": true\n" +
            "    }\n";

    private final String userNullUpdateRequestBodyJSON = "{\n" +
            "      \"idUser\": null,\n" +
            "      \"username\": \"string\",\n" +
            "      \"mail\": \"string@alice.it\",\n" +
            "      \"birthday\": \"2000-09-11 00:00:00\",\n" +
            "      \"age\": 19,\n" +
            "      \"isFemale\": true\n" +
            "    }\n";

    private final String mailNullUpdateRequestBodyJSON = "{\n" +
            "      \"idUser\": 10,\n" +
            "      \"username\": \"string\",\n" +
            "      \"mail\": null,\n" +
            "      \"birthday\": \"2000-09-11 00:00:00\",\n" +
            "      \"age\": 19,\n" +
            "      \"isFemale\": true\n" +
            "    }\n";

    /**********     RESPONSE json    **********/
    private final String updateUserOnInitResponse = "{\n" +
            "  \"code\": 0,\n" +
            "  \"message\": \"Success\",\n" +
            "  \"path\": \"http://localhost:8080/users\",\n" +
            "  \"numberOfUser\": 1,\n" +
            "  \"userList\": [\n" +
            "    {\n" +
            "      \"idUser\": 10,\n" +
            "      \"username\": \"usernameNew\",\n" +
            "      \"mail\": \"string@alice.it\",\n" +
            "      \"birthday\": \"2000-09-11 00:00:00\",\n" +
            "      \"age\": 19,\n" +
            "      \"isFemale\": true\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private final String updateUserUserNullOnInitUnauthorizedJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_INALIDUSERFIELD.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_INALIDUSERFIELD.getMessage() + "\"}";

    private final String updateUserMailNullOnInitInvalidFieldResponseJSON = "{" +
            "\"code\":"+ ResponseErrorEnum.ERR_INVALIDFIELD.getCode() +
            ",\"message\":\""+ ResponseErrorEnum.ERR_INVALIDFIELD.getMessage() + "\"}";

    @Test
    public void successOnInit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( usernameNewdUpdateRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //response
                .andExpect(content().json( updateUserOnInitResponse ))
                .andDo(print());
    }

    @Test
    public void failureForEmptySurvey() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( userNullUpdateRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized())
                //response
                .andExpect(content().json( updateUserUserNullOnInitUnauthorizedJSON ))
                .andDo(print());
    }

    @Test
    public void failureForEmptyField() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put(ENDPOINT_RESOURCE_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content( mailNullUpdateRequestBodyJSON )
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                //response
                .andExpect(content().json( updateUserMailNullOnInitInvalidFieldResponseJSON ))
                .andDo(print());
    }
}
