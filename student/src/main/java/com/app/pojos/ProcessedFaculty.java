package com.app.pojos;


public class ProcessedFaculty {

	private Faculty faculty;
	private Address address;
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ProcessedFaculty(Faculty faculty, Address address) {
		super();
		this.faculty = faculty;
		this.address = address;
	}
	public ProcessedFaculty() {
		super();
	}
	


}
