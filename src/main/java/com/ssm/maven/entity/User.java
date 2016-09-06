package com.ssm.maven.entity;

public class User {
    private Integer userId;
    private String userName;
    private String tel;
	private Integer age;
    private Address address;
	public User(Integer userId, String userName, String tel, Integer age, Address address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.tel = tel;
		this.age = age;
		this.address = address;
	}
	public User() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", tel=" + tel + ", age=" + age + ", address="
				+ address + "]";
	}





	
    
}