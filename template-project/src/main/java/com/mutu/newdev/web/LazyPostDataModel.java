package com.mutu.newdev.web;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.mutu.newdev.dto.Post;
import com.mutu.newdev.dto.PostCriteria;
import com.mutu.newdev.dto.PostPaginData;
import com.mutu.newdev.service.PostService;

public class LazyPostDataModel extends LazyDataModel<Post> {
	private PostService postService;
	private PostCriteria postCriteria;
	public LazyPostDataModel(PostService postService, PostCriteria postCriteria) {
        this.postCriteria = postCriteria;
        this.postService = postService;
    }
	
	@Override
    public List<Post> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		postCriteria.setOffset(first);	
		postCriteria.setLimit(pageSize);	
		PostPaginData postPaginData = postService.find(postCriteria);
		List<Post> datasource = postPaginData.getPostList();
		setRowCount(postPaginData.getCount());
		setPageSize(postCriteria.getLimit());
		return datasource;
	}
}
