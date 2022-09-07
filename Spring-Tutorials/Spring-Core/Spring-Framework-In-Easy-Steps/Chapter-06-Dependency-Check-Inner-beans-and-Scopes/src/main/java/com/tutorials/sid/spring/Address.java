/**
 * 
 */
package com.tutorials.sid.spring;

/**
 * @author Lenovo
 *
 */
public class Address {
	private int houseNo;
	private String buildingName;
	private String streetName;
	private double pin;

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
