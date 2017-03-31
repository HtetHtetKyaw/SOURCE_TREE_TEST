package com.techfun.job.dao;

import java.util.List;

import com.techfun.job.entity.JobCategory;
import com.techfun.job.entity.JobCategoryExample;
import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;

public interface HomeDao {
	
	/** Select jobList */
	List<JobDetail> selectJobList(JobDetailExample example);
	
	/** Select Job Category List. */
	List<JobCategory> selectJobCategoryList(JobCategoryExample example);
}
