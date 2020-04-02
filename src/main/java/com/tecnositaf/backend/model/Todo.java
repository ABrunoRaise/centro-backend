package com.tecnositaf.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo {

	@JsonProperty("userId")
	String idUserFk;
	@JsonProperty("id")
	String idTodo;
	String title;
	@JsonProperty("completed")
	Boolean isComplete;
	
	public Todo(String idUserFk, String idTodo, String title, Boolean isComplete) {
		this.idUserFk = idUserFk;
		this.idTodo = idTodo;
		this.title = title;
		this.isComplete = isComplete;
	}
	
	public Todo() {}
	
	public String getIdUserFk() {
		return idUserFk;
	}
	public void setIdUserFk(String idUserFk) {
		this.idUserFk = idUserFk;
	}
	public String getIdTodo() {
		return idTodo;
	}
	public void setIdTodo(String idTodo) {
		this.idTodo = idTodo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	
}
