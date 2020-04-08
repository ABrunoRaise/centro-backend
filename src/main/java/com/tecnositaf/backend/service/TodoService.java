package com.tecnositaf.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.tecnositaf.backend.model.Todo;
import com.tecnositaf.backend.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepository;

	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Todo getTodoById(String idTodo) {

		log.info("In get todo by Id");
		return todoRepository.getTodoById(idTodo);
	}
	
}
