package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.NotesRepository;
import com.app.pojos.Notes;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class NotesServiceImpl implements INotesService {
	
	@Autowired
	private NotesRepository notesRepo;

	@Override
	public void uploadNotes(Notes notes) {
		notesRepo.save(notes);
	}

	@Override
	public List<Notes> getAllNotes() {
		return notesRepo.findAll();
	}


}
