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
	private LoginRepository loginRepo;

	@Override
	public List<Login> getAll() {
		List<Login> optional = loginRepo.findAll();
			return optional;
	}

		@Override
	public Login getLoginDetails(String name, String password) {
		Login optional = loginRepo.findByUserNameAndPassword(name,password);
		return optional;
	}

		@Override
		public Login getLoginById(Integer id) {
			return loginRepo.findById(id).orElse(null);
		}

		@Override
		public Login getLoginByUserName(String userName) {
			
			return loginRepo.findByUserName(userName);
		}


}
