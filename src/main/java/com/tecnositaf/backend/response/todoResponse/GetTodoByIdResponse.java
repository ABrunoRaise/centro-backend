package com.tecnositaf.backend.response.todoResponse;


import com.tecnositaf.backend.dto.DTOTodo;
import com.tecnositaf.backend.model.Todo;
import com.tecnositaf.backend.response.Response;

public class GetTodoByIdResponse extends Response{
	
	DTOTodo todo;
	
	public GetTodoByIdResponse(int code, String message, String path, Todo todo) {
		super(code, message, path);
		this.todo = todo.toDTOTodo();
	}

	public GetTodoByIdResponse(String path, Todo todo) {
		super(0, "Success", path);
		this.todo = todo.toDTOTodo();
	}

	public DTOTodo getTodo() {
		return todo;
	}

	public void setTodo(DTOTodo todo) {
		this.todo = todo;
	}	
}
