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
@Table(name = "login")
@JsonInclude(Include.NON_DEFAULT)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Integer loginId;
	@Column(length = 20)
	@JsonProperty("userName")
	private String userName;
	@Column(length = 20)
	@JsonProperty("password")
	private String password;
	@Column(length = 20)
	@JsonProperty("role")
	private String role;
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", userName=" + userName + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	
	
	
	}
