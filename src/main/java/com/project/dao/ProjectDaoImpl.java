package com.project.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Project;
import com.project.model.User;


@Repository("projectDao")
@Transactional
public class ProjectDaoImpl extends AbstractDao<Integer,Project> implements ProjectDao {

	public void saveProject(Project project) 
	{
		persist(project);

	}

	public Project findProjectById(int id) 
	{
		
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<Project> findAllProject() 
	{
		Criteria cr= createEntityCriteria();
		return (List<Project>) cr.list();
		
	}

	@SuppressWarnings("unchecked")
	public List<Project> findProjectByUser(User user) 
	{
		Criteria cr= createEntityCriteria();
		cr.add(Restrictions.eq("userProjects", user));
		return (List<Project>)cr.list();
	}

	public void deleteProjectById(int projectId) 
	{
		
		Query query=getSession().createSQLQuery("delete from projects where Id=:id");
		query.setInteger("id", projectId);
		query.executeUpdate();
		//getSession().delete(getByKey(projectId));
		
	}

	public Project findProjectByName(String name) 
	{
		
			Criteria crit = createEntityCriteria();
	        crit.add(Restrictions.eq("projectName", name));
	        Project findProject=(Project)crit.uniqueResult();
			return findProject;
		
	}
	
	
}
