package com.project.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.form.UserLoginForm;
import com.project.model.Project;
import com.project.model.User;

@Service("userServie")
@Transactional
public class UserServiceImpl implements UserService 
{

	@Autowired
	private UserDao userDao;
	public User findUserById(int id) 
	{
		
		return userDao.findUserById(id);
	}

	public void deleteUserById(int id) 
	{
	
		userDao.deleteUserById(id);
	}

	public List<User> findAllUsers() 
	{
		
		return userDao.findAllUsers();
	}

	public void updateUser(User user) 
	{
		User updatedUser=userDao.findUserById(user.getId());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setUserName(user.getUserName());
		updatedUser.setEmail(user.getEmail());
   
	}

	public void saveUser(User user)
	{
		
		userDao.saveUser(user);
	}

	public boolean loginControl(UserLoginForm userLoginForm) 
	{
		//System.out.println(userLoginForm.getUserName());
		User findUser=userDao.findUserByUsername(userLoginForm.getUserName());
		System.out.println("veritabaný:"+findUser.getPassword());
		System.out.println("gelen:"+userLoginForm.getPassword());
		
		if(findUser.getPassword().equals(userLoginForm.getPassword()))
		{
			System.out.println("girdi");
			return true;
		}
		else
		{
			return false;
		}
	  
	}

	public User arrangeUser(User user) 
	{
		user.setEmail(user.getEmail().trim());
		user.setUserName(user.getUserName().trim());
		user.setPassword(user.getPassword().trim());
		return user;
	}

	@SuppressWarnings("unchecked")
	public Set<Project> findUserProject(String username) 
	{
		User user=userDao.findUserByUsername(username);
		
		return user.getProjects();
	}

	public User findUserByName(String name) 
	{
		
		return userDao.findUserByUsername(name);
	}

	
    
}
