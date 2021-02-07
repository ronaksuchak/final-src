package com.app.service;

import java.util.List;

import com.app.pojos.Faculty;

public interface IFacultyService {
	List<Faculty> getAllFaculties();
	Faculty registerFaculty(Faculty faculty);
	Faculty getFacultyByName(String name);
	Faculty getFacultyById(Integer facultyId);
	void deleteFacultyById(Integer id);
   
}
