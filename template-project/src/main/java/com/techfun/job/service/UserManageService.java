package com.techfun.job.service;

import java.util.List;

import com.techfun.job.entity.JobDetail;

public interface UserManageService {

	/** get jobList by userId. */
	List<JobDetail> getJobList(Integer userId, Integer jobCategoryId);
	
	/** Delete selected  job. */
	int deleteJob(Integer jobId);
	
}
