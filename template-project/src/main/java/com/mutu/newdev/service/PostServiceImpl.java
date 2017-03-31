/***************************************************************************************
 * @author <<Your Name>>
 * @Date 2014-08-06
 * @Version 1.0
 * @Purpose <<You have to write the comment the main purpose of this class>>
 * 
 *    
 ***************************************************************************************/
package com.mutu.newdev.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutu.newdev.dao.PostDao;
import com.mutu.newdev.dto.PostCriteria;
import com.mutu.newdev.dto.PostPaginData;
import com.mutu.newdev.exception.DAOException;
import com.mutu.newdev.exception.SystemException;

@Service(value = "PostService")
public class PostServiceImpl implements PostService {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private PostDao postDAO;
	
	public PostPaginData find(PostCriteria postCriteria) throws SystemException {
		PostPaginData result = null;
		try {
			logger.debug("findAllPost() method has been started.");
			result = postDAO.find(postCriteria);
			logger.debug("findAllPost() method has been successfully finisehd.");
		} catch (DAOException e) {
			logger.error("findAllPost() method has been failed.");
			throw new SystemException(e.getErrorCode(),
					"Faield to find all of post)", e);
		}
		return result;
	}
	
	public int count() throws SystemException {
		int result = 0;
		try {
			logger.debug("count() method has been started.");
			result = postDAO.count();
			logger.debug("count() method has been successfully finisehd.");
		} catch (DAOException e) {
			logger.error("count() method has been failed.");
			throw new SystemException(e.getErrorCode(), "Faield to count all of post)", e);
		}
		return result;
	}
}
