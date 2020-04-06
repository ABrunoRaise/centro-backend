package com.tecnositaf.backend.service.todo;

import com.tecnositaf.backend.CentroBackendApplication;
import com.tecnositaf.backend.model.Todo;
import com.tecnositaf.backend.service.TodoService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CentroBackendApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    public void testGetTodoService(){
        Todo todoFromService = todoService.getTodoById("1");

        Todo todoForTest = new Todo();
        todoForTest.setIdTodo("1");
        todoForTest.setTitle("delectus aut autem");
        todoForTest.setIdUserFk("1");
        todoForTest.setIsComplete(false);
        assert(todoForTest.equals(todoFromService));
    }
}
