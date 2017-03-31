package com.techfun.job.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.newdev.exception.DAOException;
import com.mutu.newdev.exception.SystemException;
import com.techfun.job.dao.NewUserRegisterDao;
import com.techfun.job.entity.UserExample;

@Service(value = "NewUserRegisterService")
public class NewUserRegisterServiceImpl implements NewUserRegisterService {

	@Autowired
	private NewUserRegisterDao dao;

	private Logger logger = Logger.getLogger(this.getClass());

	public int checkUsername(String username) throws SystemException {

		int count = 0;
		try {
			logger.debug("checkUsername() method has been started");
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(username);
			count = dao.checkUsername(example);
			logger.debug("checkUsername() method has been successfully finished");
		} catch (DAOException e) {
			logger.error("checkUsername() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get userinfo)", e);
		}
		return count;
	}
}
