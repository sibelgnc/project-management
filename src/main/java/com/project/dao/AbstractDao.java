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
		//burada aslýnda normal select query çalýþýyor kriter olarak bu sýnýfa ait verileri getir deniyor
		//aslýnda select * form persistentClass þeklinde çalýþmaktadýr
		//ek olarak kýsýtlamalar yaparakta sorgu çalýþtýrýlabilir
		//select * from persistentClass where salary=200
		//cr.add(Restrictions.eq("salary", 200)); bu þekilde yapýlabilir
		return getSession().createCriteria(persistentClass);
	}
}
