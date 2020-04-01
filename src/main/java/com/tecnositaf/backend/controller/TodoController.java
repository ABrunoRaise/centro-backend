package com.tecnositaf.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tecnositaf.backend.model.Todo;
import com.tecnositaf.backend.response.Response;
import com.tecnositaf.backend.response.todoResponse.GetTodoByIdResponse;
import com.tecnositaf.backend.service.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping(path = "/todos/{idTodo}")
	public ResponseEntity<Response> getTable(@PathVariable String idTodo){
		 	    
		Todo todoToReturn = todoService.getTodoById(idTodo);
		//TODO exist check
	    return ResponseEntity.status(HttpStatus.OK).body(
	    	new GetTodoByIdResponse(
	    		ServletUriComponentsBuilder.fromCurrentRequest().toUriString(),
	    		todoToReturn
	    	));
	}
	
}
