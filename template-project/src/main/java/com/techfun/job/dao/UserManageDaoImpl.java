package com.techfun.job.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;
import com.techfun.job.mapper.JobDetailMapper;

@Repository
public class UserManageDaoImpl implements UserManageDao {

	@Autowired
	private JobDetailMapper mapper;
	
	public List<JobDetail> getJobList(JobDetailExample example) {
		
		return mapper.selectByExample(example);
	}

	public int deleteJob(Integer jobId) {
		
		return mapper.deleteByPrimaryKey(jobId);
	}

}
