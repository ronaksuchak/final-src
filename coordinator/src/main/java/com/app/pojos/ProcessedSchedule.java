package com.app.pojos;


public class ProcessedSchedule {

	private Faculty faculty;
	private Subject subject;
	private Schedule schedule;
	
	public ProcessedSchedule(){
		
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public ProcessedSchedule(Faculty faculty, Subject subject, Schedule schedule) {
		super();
		this.faculty = faculty;
		this.subject = subject;
		this.schedule = schedule;
	}
	@Override
	public String toString() {
		return "ProcessedSchedule [faculty=" + faculty + ", subject=" + subject + ", schedule=" + schedule + "]";
	}
	
}
