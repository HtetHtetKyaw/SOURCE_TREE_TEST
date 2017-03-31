package com.techfun.job.dao;

import java.util.List;

import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;

public interface UserManageDao {

	/** get jobList by userId. */
	List<JobDetail> getJobList(JobDetailExample example);
	
	/** Delete selected  job. */
	int deleteJob(Integer jobId);
}
