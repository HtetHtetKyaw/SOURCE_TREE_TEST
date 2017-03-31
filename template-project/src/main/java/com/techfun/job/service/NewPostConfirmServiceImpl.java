package com.techfun.job.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.newdev.exception.DAOException;
import com.mutu.newdev.exception.SystemException;
import com.techfun.job.dao.NewPostConfirmDao;
import com.techfun.job.entity.JobDetail;

@Service(value = "NewPostConfService")
public class NewPostConfirmServiceImpl implements NewPostConfirmService {

	@Autowired
	private NewPostConfirmDao dao;

	private Logger logger = Logger.getLogger(this.getClass());

	public int insertJob(JobDetail jobDetail, Integer userId) throws SystemException {

		int result = 0;
		try {
			logger.debug("insertJob() method has been started");
			jobDetail.setUserId(userId);
			jobDetail.setCreateDt(new Date());
			jobDetail.setUpdateDt(new Date());
			jobDetail.setJobCategoryJobCategoryId(jobDetail.getJobCategoryId());
			jobDetail.setUserUserId(jobDetail.getUserId());
			jobDetail.setDeleteFlg(0);
			result = dao.insertJob(jobDetail);
			logger.debug("insertJob() method has been successfully finished");
		} catch (DAOException e) {
			logger.error("insertJob() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get insert new job)", e);
		}
		return result;
	}

}
