package com.tecnositaf.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.tecnositaf.backend.model.Todo;

@Repository
public class TodoRepository{

	//TODO @Value da services.properties
	String urlTodos = "https://jsonplaceholder.typicode.com/todos";

	@Autowired
	RestTemplate restTemplate;

	public Todo getTodo(String idTodo) {
		//TODO restTemplate.exchange(...)
		return null;//getForObject(urlTodos + "/" + idTodo, Todo.class);
	}
	
}
