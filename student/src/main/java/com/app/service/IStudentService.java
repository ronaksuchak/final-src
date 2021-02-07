package com.app.service;

import java.util.List;

import com.app.pojos.Address;
import com.app.pojos.Student;

public interface IStudentService {
	List<Student> getAllStudents();
//	Student registerStudent(Student s,Address a);
	Student registerStudent(Student student);
	Student getStudentByName(String name);
	Student getStudentById(Integer studentId);
	
	void deleteStudentById(Integer id);

}
