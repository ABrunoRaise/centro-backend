package com.tecnositaf.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.tecnositaf.backend.model.Todo;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Repository
public class TodoRepository{

	@Value("${todoRestServiceUrl}")
	String urlTodos;

	@Autowired
	RestTemplate restTemplate;

	public Todo getTodoById(String idTodo) {

		return restTemplate.exchange(
				urlTodos + "/" + idTodo,
				HttpMethod.GET,
				null,
				Todo.class).getBody();
	}
	
}
