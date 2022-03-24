package com.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
@Table(name="Users")
public class User 
{
	//Tablo isimleri asla çoðul olmamalý!
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	//TODO 1 - kelimelerin ilk harfi büyük baþlamaz. (Id)
	//TODO 2 - String formatýnda tanýmladýðýn deðerlere mutlaka length bilgisi ver. Veritabanýndaki length ile uyumlu olsun
	//Daha sonrasýnda modeldeki length deðerini HTML tarafýnda textbox a max length vererek kýsýtla ki kullanýcý veritabanýndan büyük deðer giremesin.
	//Model haricinde veritabanýnda mutlaka unique constraint olsun
	
	@Column(unique=true,nullable=false)	
	private String userName;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String email;
	
	//FetchType.EAGER sadece her model çekildiðinde ihtiyaç olan nesneler için kullanýlmalý. Listeler genelde LAZY tanýmlanýr, sorgu çekildiðinde ihtiyaç olunan
	// yerde JOIN yapýlýr
	@OneToMany(fetch = FetchType.EAGER,mappedBy="userProjects",cascade=CascadeType.ALL)
	private Set<Project>projects=new HashSet<Project>();
	
	//HashCode, ToString metodlarýna LAZY deðerler, transient alanlar yazýlmaz!!!
	@Override
	public String toString() {
		return "User [Id=" + Id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", projects=" + projects + "]";
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
