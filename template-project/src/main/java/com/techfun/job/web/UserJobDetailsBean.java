package com.techfun.job.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.techfun.job.entity.JobDetail;

@ManagedBean(name = "UserJobDetailsBean")
@ViewScoped
public class UserJobDetailsBean {

	private JobDetail flashJob;
	private Integer flashJobCategoryId;

	public JobDetail getFlashJob() {
		return flashJob;
	}

	public void setFlashJob(JobDetail flashJob) {
		this.flashJob = flashJob;
	}

	public Integer getFlashJobCategoryId() {
		return flashJobCategoryId;
	}

	public void setFlashJobCategoryId(Integer flashJobCategoryId) {
		this.flashJobCategoryId = flashJobCategoryId;
	}

	@PostConstruct
	public void init() {
		this.flashJob = (JobDetail) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_job");
		this.flashJobCategoryId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("flash_jobCategoryId");
	}

	public String processBack() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("flash_jobCategoryId", flashJobCategoryId);
		return "userJobManagement";
	}
}
