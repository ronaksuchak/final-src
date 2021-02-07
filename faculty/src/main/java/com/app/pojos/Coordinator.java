package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "coordinator")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Coordinator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("coordiantor_id")
	private Integer coordiantorId;
	
	@Column(length = 20)
	@JsonProperty("first_name")
	private String firstName;
	
	@Column(length = 20)
	@JsonProperty("last_name")
	private String lastName;
	
	@Column(length = 30)
	@JsonProperty("email_id")
	private String emailId;
	
	@JsonProperty("phone_no")
	private Integer phoneNo;
	
	@JsonProperty("address_id")
	private Integer addressId;

	public Coordinator() {
		super();
	}


	@Override
	public String toString() {
		return "Coordinator [coordiantorId=" + coordiantorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", addressId=" + addressId + "]";
	}


	public Coordinator(String firstName, String lastName, String emailId, Integer phoneNo,
			Integer addressId) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.addressId = addressId;
	}


	public Integer getCoordiantorId() {
		return coordiantorId;
	}


	public void setCoordiantorId(Integer coordiantorId) {
		this.coordiantorId = coordiantorId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Integer getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
	
	
	
}

