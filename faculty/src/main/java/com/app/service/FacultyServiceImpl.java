package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.FacultyRepository;
import com.app.pojos.Faculty;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class FacultyServiceImpl implements IFacultyService {
	
	@Autowired
	private FacultyRepository FacultyRepo;
		
	@Override
	public Faculty registerFaculty(Faculty faculty) {
		return FacultyRepo.save(faculty);
	}
	
	@Override
	public List<Faculty> getAllFaculties() {
			return FacultyRepo.findAll();
	}

	@Override
	public Faculty getFacultyByName(String name) {
		
		return FacultyRepo.findByFirstName(name);
	}

	@Override
	public Faculty getFacultyById(Integer facultyId) {
		return FacultyRepo.findById(facultyId).orElse(null);		 
	}

	@Override
	public void deleteFacultyById(Integer id) {
		FacultyRepo.deleteById(id);
	}


}
