package com.bg.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.bg.dao.AbstractDao;
import com.bg.resource.Message;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public abstract class AbstractDaoImpl{
	
	@Autowired
	protected	HibernateTemplate hibernateTemplate;
	
	public void checkNotNull(Object... objectArguments){
		for(Object argument : Lists.newArrayList(objectArguments)){
			Preconditions.checkArgument(argument != null, Message.ARGUMENT_MUST_BE_NOT_NULL);
		}
	}
}
