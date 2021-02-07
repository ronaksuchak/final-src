package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	Student findByFirstName(String name);
	Student findByEmailId(String email);
		

}
