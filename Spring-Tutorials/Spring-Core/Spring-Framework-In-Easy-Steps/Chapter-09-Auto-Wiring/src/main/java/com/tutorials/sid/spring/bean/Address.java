/**
 * 
 */
package com.tutorials.sid.spring.bean;

/**
 * @author Lenovo
 *
 */
public class Address {
	private int houseNo;
	private String buildingName;
	private String streetName;
	private double pin;

	/**
	 * 
	 */
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param houseNo
	 * @param buildingName
	 * @param streetName
	 * @param pin
	 */
	public Address(int houseNo, String buildingName, String streetName, double pin) {
		super();
		this.houseNo = houseNo;
		this.buildingName = buildingName;
		this.streetName = streetName;
		this.pin = pin;
	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public double getPin() {
		return pin;
	}

	public void setPin(double pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", buildingName=" + buildingName + ", streetName=" + streetName + ", pin=" + pin + "]";
	}

}
