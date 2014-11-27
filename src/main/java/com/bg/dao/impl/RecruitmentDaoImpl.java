package com.bg.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bg.dao.RecruitmentDao;
import com.bg.exception.BgException;
import com.bg.model.Recruitment;

import java.util.List;

@Repository
@Transactional
public class RecruitmentDaoImpl  extends AbstractDaoImpl implements RecruitmentDao {
	
	public long create(Recruitment recruitment) throws DataAccessException,
			BgException {
		// TODO Auto-generated method stub
		checkNotNull(recruitment);
		return (Long) hibernateTemplate.save(recruitment);
	}
	
	public Recruitment findById(Long id) {
		// TODO Auto-generated method stub
		checkNotNull(id);
		Session session =  hibernateTemplate.
				getSessionFactory().openSession();
		return (Recruitment) session.get(Recruitment.class, id);
	}
}
