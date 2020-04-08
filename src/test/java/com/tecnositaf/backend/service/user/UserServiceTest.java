package com.tecnositaf.backend.service.user;

import com.tecnositaf.backend.CentroBackendApplication;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void TestGetUserListService(){

        List<User> usersActual  = userService.getUserList();
        assertSame(1, usersActual.size());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        User testUser = new User();
        testUser.setIdUser((long) 10);
        testUser.setUsername("string");
        testUser.setPassword("1234");
        testUser.setMail("string@alice.it");
        testUser.setBirthday(LocalDateTime.parse("2000-09-11 00:00:00",formatter));
        testUser.setIsFemale(true);

        assert(testUser.equals(usersActual.get(0)));
    }

    @Test
    public void TestGetUserByIdService(){

        User userActual  = userService.getUserById((long) 10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        User testUser = new User();
        testUser.setIdUser((long) 10);
        testUser.setUsername("string");
        testUser.setPassword("1234");
        testUser.setMail("string@alice.it");
        testUser.setBirthday(LocalDateTime.parse("2000-09-11 00:00:00",formatter));
        testUser.setIsFemale(true);

        assert(testUser.equals(userActual));
    }

    @Test
    public void TestAddUserService(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        User newUser = new User();
        newUser.setUsername("nuovo");
        newUser.setPassword("1234");
        newUser.setMail("string@alice.it");
        newUser.setBirthday(LocalDateTime.parse("2000-09-11 00:00:00",formatter));
        newUser.setIsFemale(true);

        assertSame(1,userService.addUser(newUser));
    }

    @Test
    public void TestDeleteUserService(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        User toDeleteUser = new User();
        toDeleteUser.setIdUser((long) 10);
        toDeleteUser.setUsername("string");
        toDeleteUser.setPassword("1234");
        toDeleteUser.setMail("string@alice.it");
        toDeleteUser.setBirthday(LocalDateTime.parse("2000-09-11 00:00:00",formatter));
        toDeleteUser.setIsFemale(true);

        assertSame(1,userService.deleteUser(toDeleteUser));
    }

    @Test
    public void TestUpdateUserService(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        User toUpdateUser = new User();
        toUpdateUser.setIdUser((long) 10);
        toUpdateUser.setUsername("newUsername");
        toUpdateUser.setPassword("1234");
        toUpdateUser.setMail("string@alice.it");
        toUpdateUser.setBirthday(LocalDateTime.parse("2000-09-11 00:00:00",formatter));
        toUpdateUser.setIsFemale(true);

        assertSame(1,userService.updateUserById(toUpdateUser));
    }

}
