package com.project.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProjectDao;
import com.project.dao.UserDao;
import com.project.model.Project;
import com.project.model.User;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService
{

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private UserDao userDao;
	public void saveProject(Project project) 
	{
		projectDao.saveProject(project);
	}

	public Project findProjectById(int id) 
	{
		
		return projectDao.findProjectById(id);
	}

	public void addProjectToUser(Project project, User user) 
	{
		User users=userDao.findUserById(1);
		project.setUserProjects(users);
//		users.getProjects().add(project);
		projectDao.saveProject(project);
		
		System.out.println(user.getProjects());
	}

	public List<Project> findProjectByUser(User user) 
	{
		
		return projectDao.findProjectByUser(user);
	}

	public void deleteProjectById(int projectId) 
	{
		projectDao.deleteProjectById(projectId);
		
	}

	public void updateProject(Project project) 
	{
		Project pro=projectDao.findProjectById(project.getId());
		pro.setConnectionInfo(project.getConnectionInfo());
		pro.setFinishedDate(project.getFinishedDate());
		pro.setIssuedOn(project.getIssuedOn());
		pro.setManagerName(project.getManagerName());
		pro.setProjectName(project.getProjectName());
		pro.setPurpose(project.getPurpose());
		pro.setStartingDate(project.getStartingDate());
		
		
	}

	public Project findProjectByName(String name) 
	{
		return projectDao.findProjectByName(name);
	}

	

}
