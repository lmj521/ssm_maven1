package com.ssm.maven.service;

import java.util.List;

import com.ssm.maven.entity.User;

public interface UserService {
	public User selectByPrimaryKey(Integer id);

	public int insert(User user);

	public int deleteByPrimaryKey(Integer id);

	List<User> selectAll();

	int updateByPrimaryKey(User record);

}
