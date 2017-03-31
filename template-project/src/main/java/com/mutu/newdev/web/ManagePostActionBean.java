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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.model.LazyDataModel;

import com.mutu.newdev.dto.Post;
import com.mutu.newdev.dto.PostCriteria;
import com.mutu.newdev.service.PostService;

@ManagedBean(name = "ManagePostActionBean")
@ViewScoped
public class ManagePostActionBean {
	@ManagedProperty(value = "#{PostService}")
	private PostService postService;

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	private LazyDataModel<Post> postDataModel;
	private PostCriteria postCriteria;
	
	@PostConstruct
	public void init() {
		load();

	}

	private void load() {
		postCriteria = new PostCriteria();
		postDataModel = new LazyPostDataModel(postService, postCriteria);
	}
	
	public LazyDataModel<Post> getPostDataModel() {
		return postDataModel;
	}

	public PostCriteria getPostCriteria() {
		return postCriteria;
	}

	public void setPostCriteria(PostCriteria postCriteria) {
		this.postCriteria = postCriteria;
	}

	public void search() {
		resetPagination();
		postDataModel = new LazyPostDataModel(postService, postCriteria);
	}
	
	public void reset() {
		resetPagination();
		load();
	}
	
	private void resetPagination() {
	    DataTable d = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("postTableForm:postTable");
	    d.setFirst(0);
	}
	
	public String process(Post post) {
		System.out.println("Post Name : " + post.getName());
		/*Used for page forward or navigation*/
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("request_post", post);
		/*Used for page redirect*/
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_post", post);
		return "details";
	}
}
