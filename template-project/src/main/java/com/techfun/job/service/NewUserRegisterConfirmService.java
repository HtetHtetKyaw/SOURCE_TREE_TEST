package com.techfun.job.service;

import com.techfun.job.entity.User;

public interface NewUserRegisterConfirmService {

	/** Register new user. */
	int insertUser(User user);

	/** Get Last Inserted User Id */
	Integer getLastInsertedId(String username);
}
