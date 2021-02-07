package com.app.pojos;
import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "assignment")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Assignment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("assignment_id")
	private Integer assignmentId;
	
	@JsonProperty("assignment_number")
	private Integer assignmentNumber;
		
	@Column(length = 20)
	@JsonProperty("assignment_title")
	private String assignmentTitle;
	
	@JsonProperty("subject_id")
	private Integer subjectId;
	
	@JsonProperty("student_id")
	private Integer studentId;
	

	@JsonProperty("faculty_id")
	private Integer facultyId;
	

	@JsonProperty("file_name")
	private String fileName;
	
	@JsonProperty("file_type")
	private String fileType;

	@Lob
	private byte[] data;

	
	
	
	public Assignment(Integer assignmentNumber, String assignmentTitle, Integer subjectId, Integer studentId,
			Integer facultyId, String fileName, String fileType, byte[] data) {
		super();
		this.assignmentNumber = assignmentNumber;
		this.assignmentTitle = assignmentTitle;
		this.subjectId = subjectId;
		this.studentId = studentId;
		this.facultyId = facultyId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", assignmentNumber=" + assignmentNumber
				+ ", assignmentTitle=" + assignmentTitle + ", subjectId=" + subjectId + ", studentId=" + studentId
				+ ", facultyId=" + facultyId + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + "]";
	}

	public Integer getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	public Integer getAssignmentNumber() {
		return assignmentNumber;
	}

	public void setAssignmentNumber(Integer assignmentNumber) {
		this.assignmentNumber = assignmentNumber;
	}

	public String getAssignmentTitle() {
		return assignmentTitle;
	}

	public void setAssignmentTitle(String assignmentTitle) {
		this.assignmentTitle = assignmentTitle;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	
	
}


