package com.techfun.job.dao;

import com.techfun.job.entity.JobDetail;

public interface NewPostConfirmDao {

	/** Register new job. */
	int insertJob(JobDetail jobDetail);
}
