package com.techfun.job.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techfun.job.entity.User;
import com.techfun.job.entity.UserExample;
import com.techfun.job.mapper.UserMapper;

@Repository
public class NewUserRegisterConfirmDaoImpl implements NewUserRegisterConfirmDao {

	@Autowired
	private UserMapper mapper;
	
	public int insertUser(User user) {
		
		return mapper.insert(user);
	}

	public List<User> getLatestUserInfo(UserExample example) {
		
		return mapper.selectByExample(example);
	}

}
