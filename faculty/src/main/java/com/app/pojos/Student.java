package com.app.pojos;
import java.time.LocalDate;
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
@Table(name = "Student")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("student_id")
	private Integer studentId;
	
	@Column(length = 20)
	@JsonProperty("first_name")
	private String firstName;
	
	@Column(length = 20)
	@JsonProperty("last_name")
	private String lastName;
	
	@Column(length = 30)
	@JsonProperty("email_id")
	private String emailId;
	
	
	@JsonProperty("prn")
	private Integer prn;
	
	@JsonProperty("phone_no")
	private Integer phoneNo;
	
	@JsonProperty("coordinator_id")
	private Integer cordinatorId;
	
	@JsonProperty("course_id")
	private Integer courseId;
	
	
	@JsonProperty("dob")
	private LocalDate dob;
	
	@JsonProperty("address_id")
	private Integer address;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public Integer getPrn() {
		return prn;
	}

	public void setPrn(Integer prn) {
		this.prn = prn;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getCordinatorId() {
		return cordinatorId;
	}

	public void setCordinatorId(Integer cordinatorId) {
		this.cordinatorId = cordinatorId;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", prn=" + prn + ", phoneNo=" + phoneNo + ", cordinatorId=" + cordinatorId + ", courseId="
				+ courseId + ", dob=" + dob + ", address=" + address + "]";
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