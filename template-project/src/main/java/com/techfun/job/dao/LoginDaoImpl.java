package com.techfun.job.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techfun.job.entity.User;
import com.techfun.job.entity.UserExample;
import com.techfun.job.mapper.UserMapper;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	/** UserMapper. */
	@Autowired
	private UserMapper userMapper;

	public List<User> getLoginUser(UserExample example) {
		
		return userMapper.selectByExample(example);
	}

}
