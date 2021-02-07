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
@Table(name = "subject")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("subject_id")
	private Integer subjectId;
	
	@Column(length = 20)
	@JsonProperty("subject_name")
	private String subjectName;
		
	@JsonProperty("theory_marks")
	private Integer theoryMarks;
	
	@JsonProperty("practical_marks")
	private Integer practicalMarks;
	
	@JsonProperty("faculty_id")
	private Integer facultyId;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Integer getTheoryMarks() {
		return theoryMarks;
	}

	public void setTheoryMarks(Integer theoryMarks) {
		this.theoryMarks = theoryMarks;
	}

	public Integer getPracticalMarks() {
		return practicalMarks;
	}

	public void setPracticalMarks(Integer practicalMarks) {
		this.practicalMarks = practicalMarks;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", theoryMarks=" + theoryMarks
				+ ", practicalMarks=" + practicalMarks + ", facultyId=" + facultyId + "]";
	}
	
}
