package com.tecnositaf.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.tecnositaf.backend.model.User;

@MapperScan
@Mapper
public interface UserMapper {
	
	@Select("SELECT * FROM utenti")	
	List<User> getUserList();
	

	@Select("SELECT * FROM utenti WHERE id_user = #{idUser}")	
	User getUserById(Long idUser);
	
	@Insert("INSERT into utenti (username,password,mail,birthday,is_female)"
			+ "VALUES(#{username},#{password},#{mail},#{birthday},#{isFemale})")
	void addUser(User userToInsert);
	
	@Delete("DELETE from utenti WHERE id_user = #{idUser}")
	void deleteUser(Long idUser);
}
