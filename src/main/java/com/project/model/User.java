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
	//Tablo isimleri asla �o�ul olmamal�!
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	//TODO 1 - kelimelerin ilk harfi b�y�k ba�lamaz. (Id)
	//TODO 2 - String format�nda tan�mlad���n de�erlere mutlaka length bilgisi ver. Veritaban�ndaki length ile uyumlu olsun
	//Daha sonras�nda modeldeki length de�erini HTML taraf�nda textbox a max length vererek k�s�tla ki kullan�c� veritaban�ndan b�y�k de�er giremesin.
	//Model haricinde veritaban�nda mutlaka unique constraint olsun
	
	@Column(unique=true,nullable=false)	
	private String userName;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String email;
	
	//FetchType.EAGER sadece her model �ekildi�inde ihtiya� olan nesneler i�in kullan�lmal�. Listeler genelde LAZY tan�mlan�r, sorgu �ekildi�inde ihtiya� olunan
	// yerde JOIN yap�l�r
	@OneToMany(fetch = FetchType.EAGER,mappedBy="userProjects",cascade=CascadeType.ALL)
	private Set<Project>projects=new HashSet<Project>();
	
	//HashCode, ToString metodlar�na LAZY de�erler, transient alanlar yaz�lmaz!!!
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
