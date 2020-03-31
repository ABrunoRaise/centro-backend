package com.tecnositaf.backend.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class User {

	private Long idUser;
	private String username;
	private String password;
	private String mail;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime birthday;
	private Integer age = null;
	private Boolean isFemale;
	
	
	public User(Long idUser, String username, String password, String mail, LocalDateTime birthday, Boolean isFemale) {
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.birthday = birthday;
		this.isFemale = isFemale;
	}
	
	public User() {}
	


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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setIsFemale(Boolean isFemale) {
		this.isFemale = isFemale;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", password=" + password + ", mail=" + mail
				+ ", birthDay=" + birthday + ", age=" + age + ", isFemale=" + isFemale + "]";
	}
	
	
}
