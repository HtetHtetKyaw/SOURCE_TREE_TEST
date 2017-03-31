package com.techfun.job.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.techfun.job.entity.JobDetail;

@ManagedBean(name = "EditPostBean")
@ViewScoped
public class EditPostBean {

	private JobDetail editJobDto;
	private Integer flashJobCategoryId;

	@PostConstruct
	public void init() {

		this.editJobDto = (JobDetail) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("edit_job");
		this.flashJobCategoryId = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("flash_jobCategoryId");
	}

	public JobDetail getEditJobDto() {
		return editJobDto;
	}

	public void setEditJobDto(JobDetail editJobDto) {
		this.editJobDto = editJobDto;
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

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("edit_job", editJobDto);
		return "editPostConfirm";
	}
}
