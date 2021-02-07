package com.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.app.pojos.Faculty;
import com.app.pojos.ProcessedFaculty;
import com.app.pojos.ProcessedStudent;
import com.app.pojos.Student;


@RestController 
@RequestMapping("/coordinator")

@CrossOrigin

public class CoordinatorController {
	
	@Autowired
	private RestTemplate template;

	
	public CoordinatorController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	
	@GetMapping("/nums")
	public List<Integer> testMe() {
		System.out.println("in test me");
		return Arrays.asList(1, 2, 3, 4, 5, 6);
	}
	
	@PostMapping("/students")///set-student
	public ResponseEntity<?> setStudent(@RequestBody Student student) {
		Student addedStudent= template.postForObject("http://STUDENT-SERVICE/student/set-student",student, Student.class);
		try {
			return ResponseEntity.ok(addedStudent);	
		}
	catch (RuntimeException e) {
		System.out.println("err in controller " + e);
			
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/set-studentWithAdd")
	public ResponseEntity<?> setStudentAddress(@RequestBody ProcessedStudent student) {
		Student Student= template.postForObject("http://STUDENT-SERVICE/student/set-student",student.getStudent(), Student.class);
		//Address address=template.postForObject("http://STUDENT-SERVICE/address/setAddress",student.getAddress(),Address.class);
		Address address=new Address();
		
		//System.out.println("AddressId of new address obj"+address.getAddressId());
		ProcessedStudent newProcessesStd= new ProcessedStudent();
		newProcessesStd.setAddress(address);
		newProcessesStd.setStudent(Student);
		try {
			return ResponseEntity.ok(newProcessesStd);	
		}
	catch (RuntimeException e) {
		System.out.println("err in controller " + e);
			
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/students/{id}")///update-student
	public ResponseEntity<?> updateStudent(@PathVariable Integer id,@RequestBody Student student) {
		System.out.println("updateStudent data: "+id);
		System.out.println("updateStudent data: "+student);
		try {
			return ResponseEntity.ok(template.postForObject("http://STUDENT-SERVICE/student/update/"+id,student, Student.class));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	@GetMapping("/students")
	public ResponseEntity<?> getStudents() {
	   
			try {
				return ResponseEntity.ok(template.getForObject("http://STUDENT-SERVICE/student/all-students",Student[].class));	
			}
		catch (RuntimeException e) {
			System.out.println("err in controller " + e);
				
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<?> getStudent(@PathVariable Integer id) {
	   
		Student newStd=template.getForObject("http://STUDENT-SERVICE/student/"+id,Student.class);
		//Address newAdd=template.getForObject("http://STUDENT-SERVICE/address/getAddress/"+id,Address.class);
//		ProcessedStudent stdWithAdd=new ProcessedStudent();
//		stdWithAdd.setStudent(newStd);
//		stdWithAdd.setAddress(newAdd);
//		
	   			try {
				return ResponseEntity.ok(newStd);	
			}
		catch (RuntimeException e) {
			System.out.println("err in controller " + e);
				
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> setStudent(@PathVariable Integer id) {
		System.out.println("setStudent data: "+id);
		
		try {
			template.delete("http://STUDENT-SERVICE/student/delete/"+id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

	
	@PostMapping("/set-faculty")
	public ResponseEntity<?> setFaculty(@RequestBody Faculty faculty) {
		Faculty addedFaculty= template.postForObject("http://FACULTY-SERVICE/faculty/set-faculty",faculty, Faculty.class);
		try {
			return ResponseEntity.ok(addedFaculty);	
		}
	catch (RuntimeException e) {
		System.out.println("err in controller " + e);
			
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/set-facultyWithAdd")
	public ResponseEntity<?> setFacultyWithAddress(@RequestBody ProcessedFaculty faculty) {
		Address add=faculty.getAddress();
		Address address=template.postForObject("http://STUDENT-SERVICE/address/setAddress",add,Address.class);
		System.out.println("in setFacultyWithAddress: "+address);
		faculty.getFaculty().setAddressId(address.getAddressId());
		Faculty addedFaculty= template.postForObject("http://FACULTY-SERVICE/faculty/set-faculty",faculty, Faculty.class);
		try {
			return ResponseEntity.ok(addedFaculty);	
		}
	catch (RuntimeException e) {
		System.out.println("err in controller " + e);
			
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@PutMapping("/update-faculty/{id}")
	public ResponseEntity<?> updateFaculty(@PathVariable Integer id,@RequestBody Faculty faculty) {
		System.out.println("updateFaculty data: "+id);
		System.out.println("updateFaculty data: "+faculty);
		try {
			return ResponseEntity.ok(template.postForObject("http://FACULTY-SERVICE/faculty/update/"+id,faculty, Faculty.class));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

	@GetMapping("/faculties")
	public ResponseEntity<?> getFaculties() {
	   
			try {
				return ResponseEntity.ok(template.getForObject("http://FACULTY-SERVICE/faculty/all-faculties",Faculty[].class));	
			}
		catch (RuntimeException e) {
			System.out.println("err in controller " + e);
				
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/faculty/{id}")
	public ResponseEntity<?> getFaculty(@PathVariable Integer id) {
		System.out.println("in getFaculty: ");
		Faculty newFac=template.getForObject("http://FACULTY-SERVICE/faculty/"+id,Faculty.class);
		System.out.println("data-->"+newFac);
		Address newAdd=template.getForObject("http://STUDENT-SERVICE/address/getAddress/"+newFac.getAddressId(),Address.class);
		ProcessedFaculty FacWithAdd=new ProcessedFaculty();
		FacWithAdd.setFaculty(newFac);
		FacWithAdd.setAddress(newAdd);
		
	   			try {
				return ResponseEntity.ok(FacWithAdd);	
			}
		catch (RuntimeException e) {
			System.out.println("err in controller " + e);
				
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@DeleteMapping("/delete-faculty/{id}")
	public ResponseEntity<?> setFaculty(@PathVariable Integer id) {
		System.out.println("setFaculty data: "+id);
		
		try {
			template.delete("http://FACULTY-SERVICE/faculty/delete/"+id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

	
	
//	@GetMapping("/")
//	public ResponseEntity<?> getCoordinator(@RequestBody Student student) {
//		System.out.println("in get");
//		try {
//			return ResponseEntity.ok(coordinaotrService.getCoordinator());
//		} catch (RuntimeException e) {
//			System.out.println("err in controller " + e);
//		}
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		
//	}
//	
//	
//	@PostMapping("/")
//	public ResponseEntity<?> setStudent(@RequestBody Student student) {
//		System.out.println("in getStudentByFirstName: " + student);
//		try {
//			return ResponseEntity.ok(coordinaotrService.getStudentByName(first_name));
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
//			return ResponseEntity.ok(coordinaotrService.registerStudent(id));
//		} catch (RuntimeException e) {
//			System.out.println("err in controller " + e);
//		}
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	

//	


//@PostMapping("/name")
//public ResponseEntity<?> setStudentWithAddress(@RequestBody ProcessStudent student) {
//	Student tempStudent=student.getStudent();
//	tempStudent.setAddress(tempStudent.getStudentId());
//	Address tempAddress=student.getAddress();
//	tempAddress.setAddressId(tempStudent.getStudentId());
//	System.out.println("in setStudent data: "+student.getStudent());
//	System.out.println("in setStudent address-data: "+student.getAddress());
//	Address processedAddress= template.postForObject("http://STUDENT-SERVICE/address/setAddress/"+tempStudent.getStudentId(),tempAddress, Address.class);
//	System.out.println("in setStudent address-data(processed): "+processedAddress);
//	try {
//		return ResponseEntity.ok(studentService.registerStudent(tempStudent));
//	} catch (RuntimeException e) {
//		System.out.println("err in controller " + e);
//	}
//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	
//}

}
