package com.techfun.job.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techfun.job.entity.UserExample;
import com.techfun.job.mapper.UserMapper;

@Repository
public class NewUserRegisterDaoImpl implements NewUserRegisterDao {

	@Autowired
	private UserMapper mapper;

	public int checkUsername(UserExample example) {
		
		return mapper.countByExample(example);
	}
}
