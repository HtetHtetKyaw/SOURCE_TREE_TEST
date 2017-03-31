package com.techfun.job.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.newdev.exception.DAOException;
import com.mutu.newdev.exception.SystemException;
import com.techfun.job.dao.HomeDao;
import com.techfun.job.entity.JobCategory;
import com.techfun.job.entity.JobCategoryExample;
import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;

@Service(value = "HomeService")
public class HomeServiceImpl implements HomeService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HomeDao dao;

	public List<JobDetail> selectJobList(int jobCategoryId) throws SystemException {

		List<JobDetail> list = new ArrayList<JobDetail>();
		try {
			logger.debug("selectjoblist() method has been started.");
			JobDetailExample example = new JobDetailExample();
			if (jobCategoryId != 0) {
				example.createCriteria().andJobCategoryIdEqualTo(jobCategoryId);
			}
			example.setOrderByClause("job_id DESC");
			list = dao.selectJobList(example);
			logger.debug("selectjoblist() method has been successfully finished.");
		} catch (DAOException e) {
			logger.error("selectjoblist() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get jobList)", e);
		}
		return list;
	}

	public List<JobCategory> selectJobCategoryList() throws SystemException {

		List<JobCategory> categoryList = new ArrayList<JobCategory>();
		try {
			logger.debug("selectJobCategoryList() method has been started.");
			JobCategoryExample categoryExample = new JobCategoryExample();
			categoryExample.setOrderByClause("job_category_id");
			categoryList = dao.selectJobCategoryList(categoryExample);
			logger.debug("selectJobCategoryList() method has been successfully finished.");
		} catch (DAOException e) {
			logger.error("selectJobCategoryList() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get job category list)", e);
		}
		return categoryList;
	}

	public List<JobDetail> searchJobList(String searchKeyWord) throws SystemException {

		List<JobDetail> list = new ArrayList<JobDetail>();
		try {
			logger.debug("selectjoblist() method has been started.");
			JobDetailExample example = new JobDetailExample();
			example.createCriteria().andPostTitleLike("%" + searchKeyWord + "%");
			example.setOrderByClause("create_dt DESC");
			list = dao.selectJobList(example);
			logger.debug("selectjoblist() method has been successfully finished.");
		} catch (DAOException e) {
			logger.error("selectjoblist() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get jobList)", e);
		}
		return list;
	}
}
