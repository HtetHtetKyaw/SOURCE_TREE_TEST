package com.techfun.job.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.techfun.job.entity.JobDetail;

@ManagedBean(name = "NewPostBean")
@ViewScoped
public class NewPostBean {

	private JobDetail jobDetail;
	private Integer flashJobCategoryId;

	@PostConstruct
	public void init() {

		if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("jobPost") != null) {
			jobDetail = (JobDetail) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("jobPost");
		} else {
			jobDetail = new JobDetail();
		}
		this.flashJobCategoryId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("flash_jobCategoryId");
	}

	public JobDetail getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}

	public Integer getFlashJobCategoryId() {
		return flashJobCategoryId;
	}

	public void setFlashJobCategoryId(Integer flashJobCategoryId) {
		this.flashJobCategoryId = flashJobCategoryId;
	}

	public String processBack() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("flash_jobCategoryId", flashJobCategoryId);
		return "userJobManagement";
	}

	public String processContinuous() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("jobPost", jobDetail);
		return "newPostConfirm";
	}
}
