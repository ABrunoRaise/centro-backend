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
public class GetUsersEndpointTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wepAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wepAppContext).build();
    }

    private final String ENDPOINT_RESOURCE_BASE_URL = "http://localhost:8080/users";

    /**********     RESPONSE json    **********/
    private final String getUsersOnInitResponse = "{\n" +
            "  \"code\": 0,\n" +
            "  \"message\": \"Success\",\n" +
            "  \"path\": \"http://localhost:8080/users\",\n" +
            "  \"numberOfUser\": 1,\n" +
            "  \"userList\": [\n" +
            "    {\n" +
            "      \"idUser\": 10,\n" +
            "      \"username\": \"string\",\n" +
            "      \"mail\": \"string@alice.it\",\n" +
            "      \"birthday\": \"2000-09-11 00:00:00\",\n" +
            "      \"age\": 19,\n" +
            "      \"isFemale\": true\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Test
    public void successOnInit() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_RESOURCE_BASE_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //response
                .andExpect(content().json(getUsersOnInitResponse))
                .andDo(print());
    }
}
