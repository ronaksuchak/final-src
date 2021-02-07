package com.app.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {


	Login findByUserName(String userName);

	
}
