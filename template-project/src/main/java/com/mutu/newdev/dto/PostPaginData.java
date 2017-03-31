package com.mutu.newdev.dto;

import java.util.List;

public class PostPaginData {
	private List<Post> postList;
	private int count;
	
	public PostPaginData(List<Post> postList, int count) {
		this.postList = postList;
		this.count = count;
	}
	
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
