package com.app.pojos;


public class ProcessedNotice {

	private Faculty faculty;
	private Notice notice;
	private Coordinator coordinator;

	public ProcessedNotice(Notice notice, Faculty faculty, Coordinator coordinator) {
		this.notice=notice;
		this.faculty=faculty;
		this.coordinator=coordinator;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	@Override
	public String toString() {
		return "ProcessedNotice [faculty=" + faculty + ", notice=" + notice + ", coordinator=" + coordinator + "]";
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public Coordinator getCoordinator() {
		return coordinator;
	}
	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
}
