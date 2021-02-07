package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CoordinatorRepository;
import com.app.dao.LoginRepository;
import com.app.pojos.Login;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class CoordinatorServiceImpl implements ICoordinatorService {
	
	@Autowired
	private CoordinatorRepository coordinatorRepo;


}
