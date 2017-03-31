package com.techfun.job.service;


public interface NewUserRegisterService {

	/** check username duplication */
	int checkUsername(String username);
}
