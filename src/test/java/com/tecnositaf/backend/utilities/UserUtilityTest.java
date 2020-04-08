package com.tecnositaf.backend.utilities;

import com.tecnositaf.backend.CentroBackendApplication;
import com.tecnositaf.backend.dto.DTOUser;
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
public class UserUtilityTest {

    @Test
    public void TestSuccessIsValidUser() {
        DTOUser dtoUserToValidate = new DTOUser(
                (long) 1,
                "idUser",
                "mailUser@gmail.com",
                LocalDateTime.now(),
                0,
                false
        );

        assertTrue(UserUtility.isValidUser(dtoUserToValidate));
    }

    @Test
    public void TestFailureIsValidUser() {
        DTOUser dtoUserToValidate = new DTOUser(
                (long) 1,
                "idUser",
                "mailUser..gmail.com",
                LocalDateTime.now(),
                0,
                false
        );

        assertFalse(UserUtility.isValidUser(dtoUserToValidate));
    }

    @Test
    public void TestSuccessIsValidIdUser() {
        DTOUser dtoUserToValidate = new DTOUser(
                (long) 1,
                "idUser",
                "mailUser@gmail.com",
                LocalDateTime.now(),
                0,
                false
        );

        assertTrue(UserUtility.isValidIdUser(dtoUserToValidate));
    }

    @Test
    public void TestFailureIsValidIdUser() {
        DTOUser dtoUserToValidate = new DTOUser(
                null,
                "idUser",
                "mailUser@gmail.com",
                LocalDateTime.now(),
                0,
                false
        );

        assertFalse(UserUtility.isValidIdUser(dtoUserToValidate));
    }
}
