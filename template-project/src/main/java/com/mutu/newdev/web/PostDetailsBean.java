/***************************************************************************************
 * @author <<Your Name>>
 * @Date 2014-08-06
 * @Version 1.0
 * @Purpose <<You have to write the comment the main purpose of this class>>
 * 
 *    
 ***************************************************************************************/

package com.mutu.newdev.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.mutu.newdev.dto.Post;

@ManagedBean(name = "PostDetailsBean")
@ViewScoped
public class PostDetailsBean {
	private Post requestPost;
	private Post flashPost;
	
	@PostConstruct
	public void init() {
		this.requestPost = (Post)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("request_post");
		this.flashPost = (Post)FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_post");
	}

	public Post getRequestPost() {
		return requestPost;
	}

	public void setRequestPost(Post requestPost) {
		this.requestPost = requestPost;
	}

	public Post getFlashPost() {
		return flashPost;
	}

	public void setFlashPost(Post flashPost) {
		this.flashPost = flashPost;
	}
}
