package com.tecnositaf.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.tecnositaf.backend.model.Todo;

@Repository
public class TodoRepository{

	@Value("${service.rest.todo.url}")
	String SERVICE_REST_TODO_URL;

	@Autowired
	RestTemplate restTemplate;

	public Todo getTodoById(String idTodo) {

		return restTemplate.exchange(
				SERVICE_REST_TODO_URL + "/" + idTodo,
				HttpMethod.GET,
				null,
				Todo.class).getBody();
	}
	
}
