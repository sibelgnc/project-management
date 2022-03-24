package com.project.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;



import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Table(name="Projects")
public class Project 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	private String projectName;
	private String managerName;
	private Date issuedOn;//verilme tarihi
	private Date finishedDate;
	private Date startingDate;
	private String connectionInfo;
	private String purpose;
	
	@ManyToOne
	@JoinColumn(name="user_project_id")
	private User userProjects;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="projectNotes",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Note>notes=new HashSet<Note>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="projectTasks",cascade=CascadeType.ALL)
	private Set<Task>tasks=new HashSet<Task>();
	
	
	
	@Override
	public String toString() {
		return "Project [Id=" + Id + ", projectName=" + projectName + ", managerName=" + managerName + ", issuedOn="
				+ issuedOn + ", finishedDate=" + finishedDate + ", startingDate=" + startingDate + ", connectionInfo="
				+ connectionInfo + ", purpose=" + purpose + ", userProjects=" + userProjects + ", notes=" + notes
				+ ", tasks=" + tasks + "]";
	}
	public Set<Note> getNotes() {
		return notes;
	}
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	public User getUserProjects() {
		return userProjects;
	}
	public void setUserProjects(User userProjects) {
		this.userProjects = userProjects;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public Date getIssuedOn() {
		return issuedOn;
	}
	public void setIssuedOn(Date issuedOn) {
		this.issuedOn = issuedOn;
	}
	public Date getFinishedDate() {
		return finishedDate;
	}
	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public String getConnectionInfo() {
		return connectionInfo;
	}
	public void setConnectionInfo(String connectionInfo) {
		this.connectionInfo = connectionInfo;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}
