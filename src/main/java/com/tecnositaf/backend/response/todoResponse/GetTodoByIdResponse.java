package com.tecnositaf.backend.response.todoResponse;


import com.tecnositaf.backend.model.Todo;
import com.tecnositaf.backend.response.Response;

public class GetTodoByIdResponse extends Response{
	
	Todo todo;
	
	public GetTodoByIdResponse(int code, String message, String path, Todo todo) {
		super(code, message, path);
		this.todo = todo;
	}

	public GetTodoByIdResponse(String path, Todo todo) {
		super(0, "Success", path);
		this.todo = todo;
	}
	
	public Todo getTodo() {
		return todo;
	}

	public void setTodo(Todo todo) {
		this.todo = todo;
	}	
}
