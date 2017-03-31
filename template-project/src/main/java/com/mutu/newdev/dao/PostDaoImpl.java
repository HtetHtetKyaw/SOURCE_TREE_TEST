/***************************************************************************************
 * @author <<Your Name>>
 * @Date 2014-08-06
 * @Version 1.0
 * @Purpose <<You have to write the comment the main purpose of this class>>
 * 
 *    
 ***************************************************************************************/
package com.mutu.newdev.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.mutu.newdev.common.Utils;
import com.mutu.newdev.dto.Post;
import com.mutu.newdev.dto.PostCriteria;
import com.mutu.newdev.dto.PostPaginData;
import com.mutu.newdev.entity.Position;
import com.mutu.newdev.entity.PositionExample;
import com.mutu.newdev.exception.DAOException;
import com.mutu.newdev.mapper.PositionMapper;

@Repository
public class PostDaoImpl implements PostDao {
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private PositionMapper positionMapper;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int count() throws DAOException {
		PositionExample example = new PositionExample();
		return positionMapper.countByExample(example);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public PostPaginData find(PostCriteria postCriteria) throws DAOException {
		PostPaginData  result = null;
		
		RowBounds rowBounds = new RowBounds(postCriteria.getOffset(), postCriteria.getLimit());
		PositionExample example = new PositionExample();
		if(Utils.isEmpty(postCriteria.getName())) {
			example.createCriteria().andNameLike("%" + postCriteria.getName() + "%");	
		}
		example.setOrderByClause("name ASC");
		List<Position> positionList = positionMapper.selectByExampleWithRowbounds(example, rowBounds);
		int count = positionMapper.countByExample(example);
		List<Post> postList = null;
		if(!CollectionUtils.isEmpty(positionList)) {
			postList = new ArrayList<Post>();
			for(Position position : positionList) {
				Post post = new Post();
				post.setId(position.getId());
				post.setDescription(position.getDescription());
				post.setName(position.getName());
				postList.add(post);
			}
		}
		result = new PostPaginData(postList, count);
		return result;
	}
	
	public void insert(Post post) {
		
		
		Position position = new Position();
		position.setName(post.getName());
		position.setDescription(post.getDescription());
		int postionId = positionMapper.insertSelective(position);
		
	}
}
