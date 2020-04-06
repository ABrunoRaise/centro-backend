package com.tecnositaf.backend.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.tecnositaf.backend.dto.DTOTodo;
import org.springframework.beans.BeanUtils;

public class Todo {

	@JsonAlias("userId")
	String idUserFk;
	@JsonAlias("id")
	String idTodo;
	String title;
	@JsonAlias("completed")
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

	@Override
	public String toString() {
		return "Todo{" +
				"idUserFk='" + idUserFk + '\'' +
				", idTodo='" + idTodo + '\'' +
				", title='" + title + '\'' +
				", isComplete=" + isComplete +
				'}';
	}

	@Override
	public boolean equals(Object obj){
		if (!(obj instanceof Todo))
			return false;
		Todo toCheck = (Todo)obj;
		return (this.idUserFk.equals(toCheck.getIdUserFk()) &&
				this.idTodo.equals(toCheck.getIdTodo()) &&
				this.title.equals(toCheck.getTitle()) &&
				this.isComplete.equals(toCheck.getIsComplete())
				);
	}

	public DTOTodo toDTOTodo(){
		DTOTodo output = new DTOTodo();
		BeanUtils.copyProperties(this, output);
		return output;
	}
}
