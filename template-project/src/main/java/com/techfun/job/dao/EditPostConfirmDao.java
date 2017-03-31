package com.techfun.job.dao;

import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;

public interface EditPostConfirmDao {

	/** Update selected job. */
	int updateSelectedPost(JobDetail jobDetail, JobDetailExample example);
}
