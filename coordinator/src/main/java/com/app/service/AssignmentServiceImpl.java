package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.AssignmentRepository;
import com.app.dao.LoginRepository;
import com.app.pojos.Assignment;
import com.app.pojos.Login;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class AssignmentServiceImpl implements IAssignmentService {
	
	@Autowired
	private AssignmentRepository assignmentRepo;

	@Override
	public Assignment getAssignmentById(Integer id) {

		return assignmentRepo.findById(id).orElse(null);
	}

	@Override
	public void uploadAssignment(Assignment assignment) {

//		Assignment assignment= (Assignment) file.getResource();
		
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		  try {
//	            // Check if the file's name contains invalid characters
//	            if(fileName.contains("..")) {
//	               System.out.println("Sorry! Filename contains invalid path sequence " + fileName);
//	            }
//
//	           String fileType=file.getContentType();
//	           byte[] date=file.getBytes();
		
		assignmentRepo.save(assignment);
		
	}

	@Override
	public List<Assignment> getAllAssignments() {
		
		return assignmentRepo.findAll();
	}


}
