package com.ssm.maven.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.maven.entity.User;



@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    public int insert(User user);

    public User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}