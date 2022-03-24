package com.project.service;

import com.project.model.Note;

public interface NoteService
{
	void deleteNoteById(int id);
	void saveNote(Note note);
}
