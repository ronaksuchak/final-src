package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ProductNotFoundException;
import com.app.dao.LoginRepository;
import com.app.pojos.Login;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class LoginServiceImpl implements ILoginService {
	// dependency
	@Autowired
	private LoginRepository productRepo;

	@Override
	public Login getDetail(String userName) {
		Login optional = productRepo.findByUserName(userName);
			return optional;
	}
	
	@Override
	public List<Login> getAll() {
		List<Login> optional = productRepo.findAll();
			return optional;
	}

}
