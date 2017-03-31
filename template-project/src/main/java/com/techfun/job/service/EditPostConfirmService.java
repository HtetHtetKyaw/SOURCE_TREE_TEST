package com.techfun.job.service;

import com.techfun.job.entity.JobDetail;

public interface EditPostConfirmService {

	/** Update selected job. */
	int updateSelectedPost(JobDetail jobDetail);
}
