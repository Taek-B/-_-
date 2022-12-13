package com.demo.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	// 아이디 중복 확인
	@Select("select user_name " +
			"from user_table " +
			"where user_id = #{user_id}")
	String checkUserIdExist(String user_id);

}
