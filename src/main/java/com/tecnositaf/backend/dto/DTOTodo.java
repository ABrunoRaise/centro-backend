package com.tecnositaf.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tecnositaf.backend.model.Todo;
import org.springframework.beans.BeanUtils;

public class DTOTodo {

    @JsonProperty("userId")
    String idUserFk;
    @JsonProperty("id")
    String idTodo;
    String title;
    @JsonProperty("completed")
    Boolean isComplete;

    public DTOTodo(String idUserFk, String idTodo, String title, Boolean isComplete) {
        this.idUserFk = idUserFk;
        this.idTodo = idTodo;
        this.title = title;
        this.isComplete = isComplete;
    }

    public DTOTodo() {}

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

    public Todo toTodo(){
        Todo output = new Todo();
        BeanUtils.copyProperties(this,output);
        return output;
    }
}
