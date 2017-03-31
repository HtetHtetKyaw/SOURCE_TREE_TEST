/***************************************************************************************
 * @author <<Your Name>>
 * @Date 2014-08-06
 * @Version 1.0
 * @Purpose <<You have to write the comment the main purpose of this class>>
 * 
 *    
 ***************************************************************************************/
package com.mutu.newdev.dao;

import java.util.List;

import com.mutu.newdev.dto.Post;
import com.mutu.newdev.dto.PostCriteria;
import com.mutu.newdev.dto.PostPaginData;
import com.mutu.newdev.exception.DAOException;

public interface PostDao {
	public int count() throws DAOException;
	public PostPaginData find(PostCriteria postCriteria) throws DAOException;
}
