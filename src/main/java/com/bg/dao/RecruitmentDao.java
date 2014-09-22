package com.bg.dao;

import org.springframework.dao.DataAccessException;

import com.bg.exception.BgException;
import com.bg.model.Recruitment;

public interface RecruitmentDao extends AbstractDao{
	public abstract long create(final Recruitment recruitment) throws DataAccessException, BgException;
	public abstract Recruitment findById(Long id);
}
