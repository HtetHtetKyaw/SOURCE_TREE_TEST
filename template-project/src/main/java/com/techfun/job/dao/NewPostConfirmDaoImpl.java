package com.techfun.job.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techfun.job.entity.JobDetail;
import com.techfun.job.mapper.JobDetailMapper;

@Repository
public class NewPostConfirmDaoImpl implements NewPostConfirmDao {

	@Autowired
	private JobDetailMapper mapper;
	
	public int insertJob(JobDetail record) {
		
		return mapper.insert(record);
	}

}
