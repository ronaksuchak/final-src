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
@Table(name = "notes")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("notes_id")
	private Integer notesId;
	
	@Column(length = 20)
	@JsonProperty("topic_name")
	private String topicName;
		
	@JsonProperty("subject_id")
	private Integer subjectId;
	
	@JsonProperty("discription")
	private String discription;

	@Override
	public String toString() {
		return "Notes [notesId=" + notesId + ", topicName=" + topicName + ", subjectId=" + subjectId + ", discription="
				+ discription + "]";
	}

	public Integer getNotesId() {
		return notesId;
	}

	public void setNotesId(Integer notesId) {
		this.notesId = notesId;
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	
	
}

