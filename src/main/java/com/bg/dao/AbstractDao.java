package com.bg.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.google.common.base.Preconditions;

public abstract class AbstractDao <T extends Serializable>{
	
	@Autowired
	protected	HibernateTemplate hibernateTemplate;
	
	public int create(final T entity){
		Preconditions.checkNotNull(entity);
		return (Integer) hibernateTemplate.save(entity);
	}	         
}