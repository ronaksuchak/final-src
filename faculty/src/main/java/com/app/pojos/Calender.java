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
@Table(name = "calender")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Calender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	
	
	
	@JsonProperty("calender_date")
	private LocalDate calenderDate;
	
	@Column(length = 20)
	@JsonProperty("day_of_week")
	private String dayOfWeek;
		
	@JsonProperty("week_number")
	private Integer weekNumber;

	@Override
	public String toString() {
		return "Calender [calenderDate=" + calenderDate + ", dayOfWeek=" + dayOfWeek + ", weekNumber=" + weekNumber
				+ "]";
	}

	public LocalDate getCalenderDate() {
		return calenderDate;
	}

	public void setCalenderDate(LocalDate calenderDate) {
		this.calenderDate = calenderDate;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Integer getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}
	
	
}
