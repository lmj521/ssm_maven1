package com.ssm.maven.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssm.maven.entity.Address;

@Repository
public interface AddressMapper {
	int deleteByPrimaryKey(Integer addressId);

	public int insert(Address address);

	public Address selectByPrimaryKey(Integer addressId);

	List<Address> selectAll();

	int updateByPrimaryKey(Address record);
}
