package com.techfun.job.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.newdev.exception.DAOException;
import com.mutu.newdev.exception.SystemException;
import com.techfun.job.dao.UserManageDao;
import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;
import com.techfun.job.entity.JobDetailExample.Criteria;

@Service(value = "UserManageService")
public class UserManageServiceImpl implements UserManageService {

	@Autowired
	private UserManageDao dao;

	private Logger logger = Logger.getLogger(this.getClass());

	public List<JobDetail> getJobList(Integer userId, Integer jobCategoryId) throws SystemException {

		List<JobDetail> list = new ArrayList<JobDetail>();
		try {
			logger.debug("getJobList() method has been started.");
			JobDetailExample example = new JobDetailExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userId);
			if (jobCategoryId != null) {
				criteria.andJobCategoryIdEqualTo(jobCategoryId);
			}
			example.setOrderByClause("job_id DESC");
			list = dao.getJobList(example);
			logger.debug("getJobList() method has been successfully finished.");
		} catch (DAOException e) {
			logger.error("getJobList() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get jobList)", e);
		}
		return list;
	}

	public int deleteJob(Integer jobId) {

		int result = 0;
		try {
			logger.debug("deleteJob() method has been started.");
			result = dao.deleteJob(jobId);
			logger.debug("deleteJob() method has been successfully finished.");
		} catch (DAOException e) {
			logger.error("deleteJob() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to delete job)", e);
		}
		return result;
	}

}
