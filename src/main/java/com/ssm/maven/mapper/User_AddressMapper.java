package com.ssm.maven.mapper;

import com.ssm.maven.entity.User_Address;

public interface User_AddressMapper {
	int deleteByUserId(Integer userId);
	int selectByUserId(Integer userId);
	int insert(User_Address user_address);
}
