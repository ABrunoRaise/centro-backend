package com.tecnositaf.backend.utilities;

import com.tecnositaf.backend.CentroBackendApplication;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StringUtilityTest {

    @Test
    public void TestSuccessValidateMail(){
        assertTrue(StringUtility.validateMail("abc@gmail.com"));
    }

    @Test
    public void TestFailureValidateMail(){
        assertFalse(StringUtility.validateMail("abc...gmail.com"));
    }
}
