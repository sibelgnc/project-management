package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.NoteDao;
import com.project.model.Note;
@Service("noteService")
@Transactional
public class NoteServiceImpl implements NoteService 
{
	@Autowired
	private NoteDao noteDao;

	public void deleteNoteById(int id) 
	{
	    noteDao.deleteNoteById(id);

	}

	public void saveNote(Note note) 
	{
		noteDao.saveNote(note);

	}

}
