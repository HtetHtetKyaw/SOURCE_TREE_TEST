package com.techfun.job.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techfun.job.entity.JobCategory;
import com.techfun.job.entity.JobCategoryExample;
import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;
import com.techfun.job.mapper.JobCategoryMapper;
import com.techfun.job.mapper.JobDetailMapper;

@Repository
public class HomeDaoImpl implements HomeDao{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private JobDetailMapper jobDetailmapper;
	
	@Autowired
	private JobCategoryMapper jobCategoryMapper;

	public List<JobDetail> selectJobList(JobDetailExample example) {
		
		List<JobDetail> list = jobDetailmapper.selectByExample(example);
		return list;
	}

	public List<JobCategory> selectJobCategoryList(JobCategoryExample example) {
		
		List<JobCategory> list = jobCategoryMapper.selectByExample(example);
		return list;
	}
}
