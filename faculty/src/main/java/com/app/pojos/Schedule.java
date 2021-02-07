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
@Table(name = "schedule")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	
	@JsonProperty("calender_date")
	private LocalDate calenderDate;
	
	@JsonProperty("subject_id")
	private Integer subjectId;
	public Schedule() {
		
	}
	public Schedule(LocalDate calenderDate, Integer subjectId, Integer facultyId, String link, String startTime,
			String endTime) {
		super();
		this.calenderDate = calenderDate;
		this.subjectId = subjectId;
		this.facultyId = facultyId;
		this.link = link;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@JsonProperty("faculty_id")
	private Integer facultyId;

	@Column(length = 100)
	@JsonProperty("link")
	private String link;
		
	@Column(length = 20)
	@JsonProperty("start_time")
	private String startTime;
	
	@Column(length = 20)
	@JsonProperty("end_time")
	private String endTime;

	public LocalDate getCalenderDate() {
		return calenderDate;
	}

	public void setCalenderDate(LocalDate calenderDate) {
		this.calenderDate = calenderDate;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Schedule [calenderDate=" + calenderDate + ", subjectId=" + subjectId + ", facultyId=" + facultyId
				+ ", link=" + link + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
