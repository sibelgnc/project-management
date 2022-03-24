package com.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Project;
import com.project.model.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao
{

	public void deleteUserById(int id) 
	{
		Query query=getSession().createQuery("delete from Users where userId=:id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	public void saveUser(User user) 
	{
		persist(user);
	}

	public User findUserById(int id) 
	{
		
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() 
	{
		Criteria cr=createEntityCriteria();
		return (List<User>)cr.list();
	}

	public User findUserByUsername(String name) 
	{
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("userName", name));
     
        User findUser=(User)crit.uniqueResult();
		
		return findUser;
	}

	
}
