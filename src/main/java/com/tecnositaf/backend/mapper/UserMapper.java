package com.tecnositaf.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.tecnositaf.backend.model.User;

@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM utenti")	
	List<User> getUserList();

	@Select("SELECT * FROM utenti WHERE id_user = #{idUser}")	
	User getUserById(Long idUser);
	
	@Insert("INSERT into utenti (username,password,mail,birthday,is_female)"
			+ "VALUES(#{username},#{password},#{mail},#{birthday},#{isFemale})")
	@Options(useGeneratedKeys = true, keyProperty="idUser", keyColumn="id_user")
	Integer addUser(User userToInsert);
	
	@Delete("DELETE from utenti WHERE id_user = #{idUser}")
	Integer deleteUser(Long idUser);
	 
	@Update("UPDATE utenti SET username = #{username}, password = #{password}, mail = #{mail},"
			+ "birthday = #{birthday}, is_female = #{isFemale} WHERE id_user = #{idUser} ")
	Integer updateUser(User updatedUser);
}
