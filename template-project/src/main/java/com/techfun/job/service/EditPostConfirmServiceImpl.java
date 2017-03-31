package com.techfun.job.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.newdev.exception.DAOException;
import com.mutu.newdev.exception.SystemException;
import com.techfun.job.dao.EditPostConfirmDao;
import com.techfun.job.entity.JobDetail;
import com.techfun.job.entity.JobDetailExample;

@Service(value = "EditPostConfirmService")
public class EditPostConfirmServiceImpl implements EditPostConfirmService {

	@Autowired
	private EditPostConfirmDao dao;

	private Logger logger = Logger.getLogger(this.getClass());

	public int updateSelectedPost(JobDetail record) throws SystemException {

		int result = 0;
		try {
			logger.debug("updateSelectedPost() method has been started");
			JobDetailExample example = new JobDetailExample();
			record.setUpdateDt(new Date());
			example.createCriteria().andUserIdEqualTo(record.getUserId()).andJobIdEqualTo(record.getJobId());
			result = dao.updateSelectedPost(record, example);
			logger.debug("updateSelectedPost() method has been successfully finished");
		} catch (DAOException e) {
			logger.error("updateSelectedPost() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to get insert new job)", e);
		}
		return result;
	}
}
