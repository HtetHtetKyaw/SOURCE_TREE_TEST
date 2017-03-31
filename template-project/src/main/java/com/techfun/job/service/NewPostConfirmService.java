package com.techfun.job.service;

import com.techfun.job.entity.JobDetail;

public interface NewPostConfirmService {

	/** Register new job. 
	 * @throws Exception */
	int insertJob(JobDetail jobDetail, Integer userId) throws Exception;
	
}
