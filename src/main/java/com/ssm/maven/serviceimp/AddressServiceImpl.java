package com.ssm.maven.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.maven.entity.Address;
import com.ssm.maven.mapper.AddressMapper;
import com.ssm.maven.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	private AddressMapper addressMapper;
	@Override
	public Address selectByPrimaryKey(Integer addressId) {
		
		return addressMapper.selectByPrimaryKey(addressId);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
	public int insert(Address address) {
		
		return addressMapper.insert(address);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
	public int deleteByPrimaryKey(Integer addressId) {
		
		return addressMapper.deleteByPrimaryKey(addressId);
	}

	@Override
	public List<Address> selectAll() {
		
		return addressMapper.selectAll();
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Exception.class)
	public int updateByPrimaryKey(Address record) {
		
		return updateByPrimaryKey(record);
	}

}
