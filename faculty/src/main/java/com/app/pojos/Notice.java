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
@Table(name = "notice")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("notice_id")
	private Integer noticeId;
	
	
	@JsonProperty("coordinator_id")
	private Integer coordinatorId;
		
	@JsonProperty("fauclty_id")
	private Integer faucltyId;
	
	@Column(length = 20)
	@JsonProperty("notice_title")
	private String noticeTitle;
	
	@Column(length = 100)
	@JsonProperty("description")
	private String description;

	

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(Integer coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public Integer getFaucltyId() {
		return faucltyId;
	}

	public void setFaucltyId(Integer faucltyId) {
		this.faucltyId = faucltyId;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", coordinatorId=" + coordinatorId + ", faucltyId=" + faucltyId
				+ ", noticeTitle=" + noticeTitle + ", description=" + description + "]";
	}
}
