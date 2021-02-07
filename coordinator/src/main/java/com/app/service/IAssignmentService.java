package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Assignment;

public interface IAssignmentService {

	Assignment getAssignmentById(Integer id);
	List<Assignment> getAllAssignments();
	void uploadAssignment(Assignment assignment);
   
}
