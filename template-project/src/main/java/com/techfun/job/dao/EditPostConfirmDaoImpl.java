package com.techfun.job.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;
import com.techfun.job.mapper.JobDetailMapper;

@Repository
public class EditPostConfirmDaoImpl implements EditPostConfirmDao {

	@Autowired
	private JobDetailMapper mapper;

	public int updateSelectedPost(JobDetail jobDetail, JobDetailExample example) {
		
		return mapper.updateByExample(jobDetail, example);
	}

}
