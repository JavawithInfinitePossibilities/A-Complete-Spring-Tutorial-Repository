/**
 * 
 */
package com.tutorials.sid.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class Address {
	@Value("#{new Integer(300)}")
	private int houseNo;
	@Value("Dwarikamai Residency")
	private String buildingName;
	@Value("JCR Layout")
	private String streetName;
	@Value("560103")
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
