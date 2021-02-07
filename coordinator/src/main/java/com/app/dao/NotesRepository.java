package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Notes;


public interface NotesRepository extends JpaRepository<Notes, Integer> {
	
}
