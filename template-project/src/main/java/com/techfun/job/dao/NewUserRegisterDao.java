package com.techfun.job.dao;

import com.techfun.job.entity.UserExample;

public interface NewUserRegisterDao {

	/** check username duplication */
	int checkUsername(UserExample example);
}
