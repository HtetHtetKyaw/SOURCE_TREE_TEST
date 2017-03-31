package com.techfun.job.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.newdev.exception.DAOException;
import com.mutu.newdev.exception.SystemException;
import com.techfun.job.dao.LoginDao;
import com.techfun.job.dto.LoginDto;
import com.techfun.job.entity.User;
import com.techfun.job.entity.UserExample;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao dao;

	private Logger logger = Logger.getLogger(this.getClass());

	public List<User> getLoginUser(LoginDto dto) throws SystemException {

		List<User> list = new ArrayList<User>();
		try {
			logger.debug("getLoginUser() method has been started");
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(dto.getUsername()).andPasswordEqualTo(dto.getPassword());
			list = dao.getLoginUser(example);
			logger.debug("getLoginUser() method has been successfully finished");
		} catch (DAOException e) {
			logger.error("getLoginUser() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get login user info)", e);
		}
		return list;
	}

}
