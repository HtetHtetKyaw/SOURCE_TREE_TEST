package com.techfun.job.service;

import java.util.List;

import com.techfun.job.dto.LoginDto;
import com.techfun.job.entity.User;

public interface LoginService {

	/** loginprocess */
	List<User> getLoginUser(LoginDto dto);
}
