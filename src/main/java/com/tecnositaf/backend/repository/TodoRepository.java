package com.tecnositaf.backend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.tecnositaf.backend.model.Todo;

@Repository
public class TodoRepository extends RestTemplate{

	String urlTodos = "https://jsonplaceholder.typicode.com/todos";
	
	public Todo getTodo(String idTodo) {
		return getForObject(urlTodos + "/" + idTodo, Todo.class);
	}
	
}
