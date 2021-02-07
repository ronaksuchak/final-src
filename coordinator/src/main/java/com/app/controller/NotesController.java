package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Notes;
import com.app.service.INotesService;

@RestController 
@RequestMapping("/coordinator/notes")

@CrossOrigin

public class NotesController {
	
	
	@Autowired
	private INotesService notesService;
		
	public NotesController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadNotes(@RequestBody Notes notes) {
		System.out.println("in uploadNotes: " + notes);
		try {
			notesService.uploadNotes(notes);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	
	@GetMapping("/all-notes")
	public ResponseEntity<?> getAllNotes() {
		System.out.println("in getAllNotes");
		try {
			return ResponseEntity.ok(notesService.getAllNotes());
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
