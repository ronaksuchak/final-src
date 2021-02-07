package com.app.controller;

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

import com.app.pojos.Address;
import com.app.pojos.Login;
import com.app.pojos.Student;
import com.app.service.IAddressService;
import com.app.service.ILoginService;
import com.app.service.IStudentService;

@RestController // @Controller cls level annotation + @ResponseBody : added on ret type of ALL
				// request handling methods : annotated via : @RequestMapping , @GetMapping ...
@RequestMapping("/address")

@CrossOrigin

public class AddressController {
	// dependency : service layer i/f
	@Autowired
	private IAddressService addressService;

	@Autowired
	private IStudentService studentService;

	
	public AddressController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add new REST end point : to fetch product by name
//	@GetMapping("/getAddress/{addressId}")
//	public ResponseEntity<?> getAddressByNameId(@PathVariable Integer addressId) {
//		System.out.println("in getAddressByNameId " + addressId);
//		try {
//			return ResponseEntity.ok(addressService.getAddress(addressId));
//		} catch (RuntimeException e) {
//			System.out.println("err in controller " + e);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		
//	}
	
	
	@GetMapping("/getAddresses")
	public ResponseEntity<?> getAllAddresses() {
		System.out.println("in getAllAddresses ");
		try {
			return ResponseEntity.ok(addressService.getAll());
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping("/setAddress")
	public ResponseEntity<?> setAddress(@RequestBody Address address) {
		//Student s=studentService.getStudentById(addressId);
		//s.setAddress(addressId);
		//System.out.println("in setAddress data: "+address + "student data: "+s);
		System.out.println("in setAddress data: "+address);
		System.out.println("in setAddress data: "+address.getAddressId());
		try {
			return ResponseEntity.ok(addressService.setAddress(address));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
	@PostMapping("/setAddress/{addressId}")
	public ResponseEntity<?> setUsers(@RequestBody Address address,@PathVariable Integer addressId) {
		//Student s=studentService.getStudentById(addressId);
		//s.setAddress(addressId);
		//System.out.println("in setAddress data: "+address + "student data: "+s);
		System.out.println("in setAddress data: "+address);
		try {
			return ResponseEntity.ok(addressService.setAddress(address));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	

}
