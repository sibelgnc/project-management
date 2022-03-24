package com.project.service;

import java.util.List;

import com.project.model.Project;
import com.project.model.User;

public interface ProjectService 
{
	void saveProject(Project project);
	Project findProjectById(int id);
	void addProjectToUser(Project project,User user);
	List<Project>findProjectByUser(User user);
	void deleteProjectById(int projectId);
	void updateProject(Project project);
	Project findProjectByName(String name);
}
