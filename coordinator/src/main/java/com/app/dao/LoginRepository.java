package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {


	Login findByUserName(String userName);

	Login findByUserNameAndPassword(String userName,String password);
}
