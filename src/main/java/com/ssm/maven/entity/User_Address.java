package com.ssm.maven.entity;

public class User_Address {
 private Integer id;
 private Integer userId;
 private Integer addressId;
public User_Address() {
	super();
}
public User_Address(Integer id, Integer userId, Integer addressId) {
	super();
	this.id = id;
	this.userId = userId;
	this.addressId = addressId;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public Integer getAddressId() {
	return addressId;
}
public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}
@Override
public String toString() {
	return "User_Address [id=" + id + ", userId=" + userId + ", addressId=" + addressId + "]";
}
 
	
}
