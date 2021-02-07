package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SubjectRepository;
import com.app.pojos.Subject;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class SubjectServiceImpl implements ISubjectService {
	
	@Autowired
	private SubjectRepository subjectRepo;

	@Override
	public List<Subject> getAllSubjects() {
		
		return subjectRepo.findAll();
	}

	@Override
	public Subject getSubjectById(Integer subjectId) {
		
		return subjectRepo.findBySubjectId(subjectId);
	}

}
