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

import com.app.pojos.Login;
import com.app.service.ILoginService;

@RestController // @Controller cls level annotation + @ResponseBody : added on ret type of ALL
				// request handling methods : annotated via : @RequestMapping , @GetMapping ...
@RequestMapping("/login")

@CrossOrigin

public class ProductController {
	// dependency : service layer i/f
	@Autowired
	private ILoginService loginService;

	public ProductController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add new REST end point : to fetch product by name
	@GetMapping("/name/{pName}")
	public ResponseEntity<?> getProductDetailsByName(@PathVariable String pName) {
		System.out.println("in get prd by name " + pName);
		try {
			return ResponseEntity.ok(loginService.getDetail(pName));
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@GetMapping("/name")
	public ResponseEntity<?> getAllUsers() {
		System.out.println("in get prd by name ");
		try {
			return ResponseEntity.ok(loginService.getAll());
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	

}
