package com.tecnositaf.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tecnositaf.backend.model.User;
import com.tecnositaf.backend.utilities.StringUtility;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class DTOUser {

    private Long idUser;
    private String username;
    private String mail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthday;
    private Integer age;
    private Boolean isFemale;

    public DTOUser(Long idUser, String username, String mail, LocalDateTime birthday, Integer age, Boolean isFemale) {
        this.idUser = idUser;
        this.username = username;
        this.mail = mail;
        this.birthday = birthday;
        this.age = age;
        this.isFemale = isFemale;
    }

    public  DTOUser(){}

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsFemale() {
        return isFemale;
    }

    public void setIsFemale(Boolean female) {
        isFemale = female;
    }

    public User toUser(){
        User output = new User();
        BeanUtils.copyProperties(this,output);
        String defaultPassword = StringUtility.generateCasualString();
        output.setPassword(defaultPassword);
        return output;
    }

}
