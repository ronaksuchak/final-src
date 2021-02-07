package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.pojos.Address;
import com.app.pojos.ProcessStudent;
import com.app.pojos.ProcessedStudent;
import com.app.pojos.Student;
import com.app.service.ILoginService;
import com.app.service.IStudentService;

@RestController // @Controller cls level annotation + @ResponseBody : added on ret type of ALL
				// request handling methods : annotated via : @RequestMapping , @GetMapping ...
@RequestMapping("/student")

@CrossOrigin

public class StudentController {
	// dependency : service layer i/f
	
	@Autowired
	private IStudentService studentService;
	@Autowired
	private RestTemplate template;
	
	
	public StudentController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	@GetMapping("/all-students")
	public ResponseEntity<?> getAllStudents() {
		System.out.println("in getAllStudents");
		try {
			return ResponseEntity.ok(studentService.getAllStudents());
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204 status code to show no content is found
		
	}
	
	
	// add new REST end point : to fetch product by name
	@GetMapping("/{first_name}")
	public ResponseEntity<?> getStudentByFirstName(@PathVariable String first_name) {
		System.out.println("in getStudentByFirstName: " + first_name);
		try {
			return ResponseEntity.ok(studentService.getStudentByName(first_name));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping("/set-student")
	public ResponseEntity<?> setStudent(@RequestBody Student student) {
		System.out.println("setStudent data: "+student);
		
		try {
			return ResponseEntity.ok(studentService.registerStudent(student));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping("/name")
	public ResponseEntity<?> setStudentWithAddress(@RequestBody ProcessStudent student) {
		Student tempStudent=student.getStudent();
		tempStudent.setAddress(tempStudent.getStudentId());
		Address tempAddress=student.getAddress();
		tempAddress.setAddressId(tempStudent.getStudentId());
		System.out.println("in setStudent data: "+student.getStudent());
		System.out.println("in setStudent address-data: "+student.getAddress());
		Address processedAddress= template.postForObject("http://STUDENT-SERVICE/address/setAddress/"+tempStudent.getStudentId(),tempAddress, Address.class);
		System.out.println("in setStudent address-data(processed): "+processedAddress);
		try {
			return ResponseEntity.ok(studentService.registerStudent(tempStudent));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	

}
