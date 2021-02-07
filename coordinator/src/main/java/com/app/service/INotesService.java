package com.app.service;

import java.util.List;

import com.app.pojos.Notes;

public interface INotesService {

	void uploadNotes(Notes notes);
	List<Notes> getAllNotes();
}
