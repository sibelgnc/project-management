package com.project.dao;

import com.project.model.Note;

public interface NoteDao 
{
	void deleteNoteById(int id);
	void saveNote(Note note);
}
