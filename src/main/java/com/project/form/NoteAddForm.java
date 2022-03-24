package com.project.form;

import com.project.model.Note;

public class NoteAddForm 
{
	private String noteDate;
	private Note additionNote;
	public String getNoteDate() 
	{
		return noteDate;
	}
	public void setNoteDate(String noteDate) {
		this.noteDate = noteDate;
	}
	public Note getAdditionNote() {
		return additionNote;
	}
	public void setAdditionNote(Note additionNote) {
		this.additionNote = additionNote;
	}
	
}
