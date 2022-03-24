package com.project.service;

import java.util.List;
import java.util.Set;

import com.project.form.UserLoginForm;
import com.project.model.Project;
import com.project.model.User;



public interface UserService 
{

	User findUserById(int id);
	void deleteUserById(int id);
	List<User>findAllUsers();
	void updateUser(User user);
	void saveUser(User user);
	boolean loginControl(UserLoginForm userLoginForm);
	User arrangeUser(User user);
	Set<Project>findUserProject(String username);
    User findUserByName(String name);
    
}
