package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Faculty;
import com.app.service.IFacultyService;

@RestController
@RequestMapping("/faculty")
@CrossOrigin("http://localhost:4200")
public class FacultyController {
	// dependency : service layer i/f
	
	@Autowired
	private IFacultyService facultyService;
	
	public FacultyController() {
		System.out.println("in ctor of " + getClass().getName());
	}

//	@GetMapping()
//	public List<Integer> testMe() {
//		System.out.println("in test me");
//		return Arrays.asList(1, 2, 3, 4, 5, 6);
//	}
	
	@GetMapping()//faculties
	public ResponseEntity<?> getAllFacultys() {
		System.out.println("in getAllFacultys");
		try {
			return ResponseEntity.ok(facultyService.getAllFaculties());
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204 status code to show no content is found
		
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getFacultyById(@PathVariable Integer id) {
		System.out.println("in getFacultyByFirstName: " + id);
		try {
			return ResponseEntity.ok(facultyService.getFacultyById(id));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteFacultyById(@PathVariable Integer id) {
		System.out.println("in deleteFacultyById: " + id);
		try {
			facultyService.deleteFacultyById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping()//("/set-faculty")
	public ResponseEntity<?> setFaculty(@RequestBody Faculty faculty) {
		System.out.println("setFaculty data: "+faculty);
		
		try {
			return ResponseEntity.ok(facultyService.registerFaculty(faculty));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping("/{id}")//("/{id}")//
	public ResponseEntity<?> updateFaculty(@PathVariable Integer id, @RequestBody Faculty faculty){
		Faculty oldFac = facultyService.getFacultyById(id);
		System.out.println("setFaculty old data: "+oldFac);
		System.out.println("setFaculty new data: "+faculty);
		oldFac.setFirstName(faculty.getFirstName());
		oldFac.setLastName(faculty.getLastName());
		oldFac.setAddressId(faculty.getAddressId());
		oldFac.setEmailId(faculty.getEmailId());
		oldFac.setFacultyId(faculty.getFacultyId());
		oldFac.setPhoneNo(faculty.getPhoneNo());
		oldFac.setSubjectId(faculty.getSubjectId());
		
		try {
			return ResponseEntity.ok(facultyService.registerFaculty(oldFac));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
