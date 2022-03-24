package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Tasks")
public class Task 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	private String personName;
	private String taskDefinition;
	private String responsibility;
	
	@ManyToOne
	@JoinColumn(name="project_task_id")
	private Project projectTasks;
	public Project getProjectTasks() {
		return projectTasks;
	}
	public void setProjectTasks(Project projectTasks) {
		this.projectTasks = projectTasks;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getTaskDefinition() {
		return taskDefinition;
	}
	public void setTaskDefinition(String taskDefinition) {
		this.taskDefinition = taskDefinition;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	
	
}
