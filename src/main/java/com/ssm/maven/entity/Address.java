package com.ssm.maven.entity;

public class Address {
	private Integer addressId;

	private String cityName;// 城市名称
	private String roadName;// 街道名称
	private String doorNo;// 门牌号
	public Address() {
		super();
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public Address(String cityName, String roadName, String doorNo) {
		super();
		this.cityName = cityName;
		this.roadName = roadName;
		this.doorNo = doorNo;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", cityName=" + cityName + ", roadName=" + roadName + ", doorNo="
				+ doorNo + "]";
	}

	
	
	
}
