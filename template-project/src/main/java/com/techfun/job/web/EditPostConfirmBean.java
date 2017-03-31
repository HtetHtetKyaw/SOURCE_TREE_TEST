package com.techfun.job.web;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import com.techfun.job.entity.JobDetail;
import com.techfun.job.service.EditPostConfirmService;

@ManagedBean(name = "EditPostConfirmBean")
@ViewScoped
public class EditPostConfirmBean {

	private JobDetail editJobDto;

	@ManagedProperty("#{EditPostConfirmService}")
	private EditPostConfirmService service;

	@PostConstruct
	public void init() {

		this.editJobDto = (JobDetail) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("edit_job");
	}

	public JobDetail getEditJobDto() {
		return editJobDto;
	}

	public void setEditJobDto(JobDetail editJobDto) {
		this.editJobDto = editJobDto;
	}

	public void setService(EditPostConfirmService service) {
		this.service = service;
	}

	public String processBack() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("edit_job", editJobDto);
		return "editPost";
	}

	public String processEdit() {

		String msg = null;
		int result = service.updateSelectedPost(editJobDto);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		if (result == 1) {
			msg = "Successfully edit selected job.";
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		} else {
			msg = "Failed to edit selected job.";
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
		return "userJobManagement";
	}
}
