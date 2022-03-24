package com.project.dao;

import java.util.List;


import com.project.model.Project;
import com.project.model.User;

public interface ProjectDao 
{
	void saveProject(Project project);
	Project findProjectById(int id);
	List<Project>findAllProject();
	List<Project>findProjectByUser(User user);
	void deleteProjectById(int projectId);
	Project findProjectByName(String name);
}
