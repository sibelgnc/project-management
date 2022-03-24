package com.project.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao <PK extends Serializable,T>
{
	private final Class<T> persistentClass;
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	protected Criteria createEntityCriteria(){
		//burada asl�nda normal select query �al���yor kriter olarak bu s�n�fa ait verileri getir deniyor
		//asl�nda select * form persistentClass �eklinde �al��maktad�r
		//ek olarak k�s�tlamalar yaparakta sorgu �al��t�r�labilir
		//select * from persistentClass where salary=200
		//cr.add(Restrictions.eq("salary", 200)); bu �ekilde yap�labilir
		return getSession().createCriteria(persistentClass);
	}
}
