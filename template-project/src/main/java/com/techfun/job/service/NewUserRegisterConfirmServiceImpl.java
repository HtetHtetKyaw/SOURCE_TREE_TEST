package com.techfun.job.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.newdev.exception.DAOException;
import com.techfun.job.dao.NewUserRegisterConfirmDao;
import com.techfun.job.entity.User;
import com.techfun.job.entity.UserExample;
import com.techfun.job.exception.SystemException;

@Service(value = "NewUserRegisterConfirmService")
public class NewUserRegisterConfirmServiceImpl implements NewUserRegisterConfirmService {

	@Autowired
	private NewUserRegisterConfirmDao dao;

	private Logger logger = Logger.getLogger(this.getClass());

	public int insertUser(User user) throws SystemException {

		int result = 0;
		try {
			logger.debug("insertUser() method has been started");
			user.setCreateDt(new Date());
			result = dao.insertUser(user);
			logger.debug("insertUser() method has been successfully finished");
		} catch (DAOException e) {
			logger.error("insertUser() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get insert new user)", e);
		}
		return result;
	}

	public Integer getLastInsertedId(String username) throws SystemException {

		Integer userId = null;
		try {
			logger.debug("getLastInsertedId() method has been started");
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(username);
			List<User> userList = dao.getLatestUserInfo(example);
			userId = userList.get(0).getUserId();
			logger.debug("getLastInsertedId() method has been successfully finished");
		} catch (DAOException e) {
			logger.error("getLastInsertedId() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get last inserted user id)", e);
		}
		return userId;
	}

}
