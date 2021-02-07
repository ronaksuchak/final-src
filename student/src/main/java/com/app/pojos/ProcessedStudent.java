package com.app.pojos;


public class ProcessedStudent {

	private Student student;
	private Address address;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ProcessedStudent(Student student, Address address) {
		super();
		this.student = student;
		this.address = address;
	}
	public ProcessedStudent() {
		super();
	}
	


}
