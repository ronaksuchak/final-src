package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.dao.StudentRepository;
import com.app.pojos.Address;
import com.app.pojos.Student;

@Service // mandatory
@Transactional
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Student registerStudent(Student student) {
		return studentRepo.save(student);
	}
	
//	@Override
//	public Student registerStudent(Student s,Address a) {
//		a=addressRepo.save(a);
//		s.setAddress(a.getAddressId());
//		return studentRepo.save(s);
//	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentByName(String name) {
		
		return studentRepo.findByFirstName(name);
	}

	@Override
	public Student getStudentById(Integer studentId) {
		return studentRepo.findById(studentId).orElse(null);		 
	}
	
		
}
