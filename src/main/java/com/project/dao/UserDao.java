package com.project.dao;

import java.util.List;

import com.project.model.Project;
import com.project.model.User;



public interface UserDao 
{
	void deleteUserById(int id);
	void saveUser(User user);
	User findUserById(int id);
	List <User> findAllUsers();
	User findUserByUsername(String name);
	
}
