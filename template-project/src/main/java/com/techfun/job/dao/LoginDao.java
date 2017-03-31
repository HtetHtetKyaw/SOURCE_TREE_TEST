package com.techfun.job.dao;

import java.util.List;

import com.techfun.job.entity.User;
import com.techfun.job.entity.UserExample;

public interface LoginDao {

	/** loginprocess */
	List<User> getLoginUser(UserExample example);
}
