package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.pojos.Address;
import com.app.pojos.ProcessStudent;
import com.app.pojos.Student;
import com.app.service.IStudentService;

@RestController 
@RequestMapping("/")

@CrossOrigin

public class Controller {
	
	@Autowired
	private IStudentService studentService;
		
	public Controller() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/")
	public ResponseEntity<?> get() {
		System.out.println("in get");
		try {
			return ResponseEntity.ok(studentService.getAllStudents());
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	
//	@PostMapping("/")
//	public ResponseEntity<?> setStudent(@RequestBody Student student) {
//		System.out.println("in getStudentByFirstName: " + student);
//		try {
//			return ResponseEntity.ok(studentService.getStudentByName(first_name));
//		} catch (RuntimeException e) {
//			System.out.println("err in controller " + e);
//		}
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		
//	}
//	
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
//		System.out.println("setStudent data: "+id);
//		
//		try {
//			return ResponseEntity.ok(studentService.registerStudent(id));
//		} catch (RuntimeException e) {
//			System.out.println("err in controller " + e);
//		}
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> setStudenta(@PathVariable Integer id) {
//		System.out.println("setStudent data: "+id);
//		
//		try {
//			return ResponseEntity.ok(studentService.delete(id));
//		} catch (RuntimeException e) {
//			System.out.println("err in controller " + e);
//		}
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}
//	
	/*
	 * @PostMapping("/name") public ResponseEntity<?>
	 * setStudentWithAddress(@RequestBody ProcessStudent student) { Student
	 * tempStudent=student.getStudent();
	 * tempStudent.setAddress(tempStudent.getStudentId()); Address
	 * tempAddress=student.getAddress();
	 * tempAddress.setAddressId(tempStudent.getStudentId());
	 * System.out.println("in setStudent data: "+student.getStudent());
	 * System.out.println("in setStudent address-data: "+student.getAddress());
	 * Address processedAddress=
	 * template.postForObject("http://STUDENT-SERVICE/address/setAddress/"+
	 * tempStudent.getStudentId(),tempAddress, Address.class);
	 * System.out.println("in setStudent address-data(processed): "+processedAddress
	 * ); try { return
	 * ResponseEntity.ok(studentService.registerStudent(tempStudent)); } catch
	 * (RuntimeException e) { System.out.println("err in controller " + e); } return
	 * new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 */

}
