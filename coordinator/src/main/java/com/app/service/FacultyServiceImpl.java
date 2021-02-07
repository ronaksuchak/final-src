package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FacultyRepository;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class FacultyServiceImpl implements IFacultyService {
	
	@Autowired
	private FacultyRepository facultyRepo;


}
