package com.ssm.maven.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.maven.entity.Address;
import com.ssm.maven.entity.User;
import com.ssm.maven.entity.User_Address;
import com.ssm.maven.mapper.AddressMapper;
import com.ssm.maven.mapper.UserMapper;
import com.ssm.maven.mapper.User_AddressMapper;
import com.ssm.maven.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private User_AddressMapper user_addressMapper;
	@Override
	public User selectByPrimaryKey(Integer id)
	{
		int addressId = user_addressMapper.selectByUserId(id);
		Address address = addressMapper.selectByPrimaryKey(addressId);
		User user = userMapper.selectByPrimaryKey(id);
		user.setAddress(address);
		return user;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
	public int insert(User user)
	{
		Address address = user.getAddress();
		int insert = userMapper.insert(user);
		Integer userId = user.getUserId();
		int insert2 = addressMapper.insert(address);
		Integer addressId = address.getAddressId();
		User_Address user_Address = new User_Address();
		user_Address.setAddressId(addressId);
		user_Address.setUserId(userId);
		user_addressMapper.insert(user_Address);
		return 1;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
	public int deleteByPrimaryKey(Integer id) {
		int addressId = user_addressMapper.selectByUserId(id);
		int result = addressMapper.deleteByPrimaryKey(addressId);
		user_addressMapper.deleteByUserId(id);
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<User> selectAll() {
		List<User> userList = userMapper.selectAll();
		for (User user : userList) {
			Address address = addressMapper.selectByPrimaryKey(user_addressMapper.selectByUserId(user.getUserId()));
			user.setAddress(address);
		}
		return userList;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
	public int updateByPrimaryKey(User record) {
		Address address = record.getAddress();
		int key = addressMapper.updateByPrimaryKey(address);
		int key2 = userMapper.updateByPrimaryKey(record);
		return key;
	}
}
