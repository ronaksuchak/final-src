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
@Table(name = "faculty")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("faculty_id")
	private Integer facultyId;
	
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

	@JsonProperty("subject_id")
	private Integer subjectId;

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
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

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Faculty(Integer facultyId, String firstName, String lastName, String emailId, Integer phoneNo,
			Integer addressId, Integer subjectId) {
		super();
		this.facultyId = facultyId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.addressId = addressId;
		this.subjectId = subjectId;
	}

	public Faculty() {
		super();
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", phoneNo=" + phoneNo + ", addressId=" + addressId + ", subjectId=" + subjectId + "]";
	}
	
	
}





/*
student_id int AI PK 
first_name varchar(45) 
last_name varchar(45) 
email_id varchar(45) 
PRN varchar(45) 
phone_no varchar(45) 
coordinator_id varchar(45) 
dob date 
address int 

 */