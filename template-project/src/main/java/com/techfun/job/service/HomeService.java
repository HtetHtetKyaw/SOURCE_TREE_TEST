package com.techfun.job.service;

import java.util.List;

import com.techfun.job.entity.JobCategory;
import com.techfun.job.entity.JobDetail;

public interface HomeService {

	/** Select jobList by job category id. */
	List<JobDetail> selectJobList(int jobCategoryId);

	/** Select Job Category List. */
	List<JobCategory> selectJobCategoryList();

	/** Search result jobList */
	List<JobDetail> searchJobList(String searchKeyWord);
}
