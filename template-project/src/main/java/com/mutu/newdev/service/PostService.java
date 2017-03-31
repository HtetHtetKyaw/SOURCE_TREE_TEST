/***************************************************************************************
 * @author <<Your Name>>
 * @Date 2014-08-06
 * @Version 1.0
 * @Purpose <<You have to write the comment the main purpose of this class>>
 * 
 *    
 ***************************************************************************************/
package com.mutu.newdev.service;

import com.mutu.newdev.dto.PostCriteria;
import com.mutu.newdev.dto.PostPaginData;
import com.mutu.newdev.exception.SystemException;

public interface PostService {
	public PostPaginData find(PostCriteria postCriteria) throws SystemException;
	public int count() throws SystemException;
}
