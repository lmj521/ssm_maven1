package com.ssm.maven.service;

import java.util.List;

import com.ssm.maven.entity.Address;



public interface AddressService {
	public Address selectByPrimaryKey(Integer addressId);

	public int insert(Address address);

	public int deleteByPrimaryKey(Integer addressId);

	List<Address> selectAll();

	int updateByPrimaryKey(Address record);
}
