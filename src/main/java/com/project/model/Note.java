package com.project.model;






import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Notes")
public class Note 
{
	private String content;
	 
   
	private Date noteDate;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;

	
	
	@ManyToOne
	@JoinColumn(name="project_note_id")
	private Project projectNotes;
	 
	public Project getProjectNotes() {
		return projectNotes;
		
	}
	public void setProjectNotes(Project projectNotes) {
		this.projectNotes = projectNotes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
}
