package com.techfun.job.dao;

import java.util.List;

import com.techfun.job.entity.User;
import com.techfun.job.entity.UserExample;

public interface NewUserRegisterConfirmDao {

	/** Register new user. */
	int insertUser(User user);

	/** Get Last Inserted UserId */
	List<User> getLatestUserInfo(UserExample example);
}
