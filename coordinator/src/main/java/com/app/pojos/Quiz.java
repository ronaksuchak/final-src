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
@Table(name = "quiz")
@JsonInclude(Include.NON_DEFAULT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("quiz_id")
	private Integer quizId;
	
	@Column(length = 100)
	@JsonProperty("question")
	private String question;
		
	@JsonProperty("topic_id")
	private Integer topicId;
	
	@Column(length = 100)
	@JsonProperty("answer")
	private String answer;

	@JsonProperty("option_1")
	private Integer option1;
	
	@JsonProperty("option_2")
	private Integer option2;
	
	@JsonProperty("option_3")
	private Integer option3;
	
	@JsonProperty("option_4")
	private Integer option4;

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", question=" + question + ", topicId=" + topicId + ", answer=" + answer
				+ ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4
				+ "]";
	}

	public Integer getQuizId() {
		return quizId;
	}

	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getOption1() {
		return option1;
	}

	public void setOption1(Integer option1) {
		this.option1 = option1;
	}

	public Integer getOption2() {
		return option2;
	}

	public void setOption2(Integer option2) {
		this.option2 = option2;
	}

	public Integer getOption3() {
		return option3;
	}

	public void setOption3(Integer option3) {
		this.option3 = option3;
	}

	public Integer getOption4() {
		return option4;
	}

	public void setOption4(Integer option4) {
		this.option4 = option4;
	}
	
	
	
}
