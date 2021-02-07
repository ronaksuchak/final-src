package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("address_id")
	private Integer addressId;
	@JsonProperty("line_1")
	private String line1;
	@JsonProperty("line_2")
	private String line2;
	private String landmark;
	private String city;
	private String state;
	private Integer pincode;
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", line1=" + line1 + ", line2=" + line2 + ", landmark=" + landmark
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

	public Address(Integer addressId, String line1, String line2, String landmark, String city, String state,
			Integer pincode) {
		super();
		this.addressId = addressId;
		this.line1 = line1;
		this.line2 = line2;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Address() {
		super();
	}
	
	
	
	
	}





/*
address_id int AI PK 
line_1 varchar(45) 
line_2 varchar(45) 
landmark varchar(45) 
city varchar(45) 
state varchar(45) 
pincode int

 */