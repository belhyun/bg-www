package com.bg.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Preconditions;

public abstract class AbstractBgDao <T extends Serializable>{
	
	private Class<T> clazz;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public final void setClazz(final Class<T> clazzToSet){
		Preconditions.checkNotNull(clazzToSet);
		clazz = clazzToSet;
	}
	
	public void create(final T entity){
		Preconditions.checkNotNull(entity);
		getCurrentSession().saveOrUpdate(entity);
	}
	
	protected final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
}
