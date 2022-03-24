package com.project.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Note;

@Repository("noteDao")
@Transactional
public class NoteDaoImpl extends AbstractDao<Integer,Note> implements NoteDao
{

	public void deleteNoteById(int noteId) 
	{
		Query query=getSession().createSQLQuery("delete from notes where Id=:id");
		query.setInteger("id", noteId);
		query.executeUpdate();
		
	}

	public void saveNote(Note note) 
	{
		// TODO Auto-generated method stub
		persist(note);
	}

}
