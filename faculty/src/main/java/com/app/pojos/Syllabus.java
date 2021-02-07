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
@Table(name = "syllabus")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Syllabus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("syllabus_id")
	private Integer syllabusId;
	
	@Column(length = 20)
	@JsonProperty("topic_name")
	private String topicName;
	

	@JsonProperty("subject_id")
	private Integer subjectId;
	
	@JsonProperty("topic_id")
	private Integer topicId;

	@Override
	public String toString() {
		return "Syllabus [syllabusId=" + syllabusId + ", topicName=" + topicName + ", subjectId=" + subjectId
				+ ", topicId=" + topicId + "]";
	}

	public Integer getSyllabusId() {
		return syllabusId;
	}

	public void setSyllabusId(Integer syllabusId) {
		this.syllabusId = syllabusId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
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