package com.techfun.job.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.techfun.job.entity.JobDetail;

@ManagedBean(name = "JobDetailsBean")
@ViewScoped
public class JobDetailsBean {

	private JobDetail flashJob;
	private String flashSearchKeyWord;
	private Integer jobCategoryId;

	public JobDetail getFlashJob() {
		return flashJob;
	}

	public void setFlashJob(JobDetail flashJob) {
		this.flashJob = flashJob;
	}

	public void setJobCategoryId(Integer jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}

	public String getFlashSearchKeyWord() {
		return flashSearchKeyWord;
	}

	public void setFlashSearchKeyWord(String flashSearchKeyWord) {
		this.flashSearchKeyWord = flashSearchKeyWord;
	}

	@PostConstruct
	public void init() {
		this.flashJob = (JobDetail) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_job");
		this.jobCategoryId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("flash_job_categoryId");
		this.flashSearchKeyWord = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("flash_job_searchKeyWord");
	}

	public String processBack() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_job_categoryId", jobCategoryId);
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("flash_job_searchKeyWord", flashSearchKeyWord);
		return "home";
	}
}
