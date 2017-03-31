package com.techfun.job.web;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import com.techfun.job.entity.JobDetail;
import com.techfun.job.service.NewPostConfirmService;

@ManagedBean(name = "NewPostConfBean")
@ViewScoped
public class NewPostConfBean {

	private JobDetail job;

	@ManagedProperty("#{NewPostConfService}")
	private NewPostConfirmService service;

	@PostConstruct
	public void init() {

		this.job = (JobDetail) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("jobPost");
	}

	public JobDetail getJob() {
		return job;
	}

	public void setJob(JobDetail job) {
		this.job = job;
	}

	public void setService(NewPostConfirmService service) {
		this.service = service;
	}

	public String processBack() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("jobPost", job);
		return "newPost";
	}

	public String processRegister() throws Exception {

		String msg = null;
		HttpSession session = SessionBean.getSession();
		int result = service.insertJob(job, (Integer)session.getAttribute("userId"));
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		if (result == 1) {
			msg = "New job was successfully registered.";
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		} else {
			msg = "Failed to register new job.";
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
		return "userJobManagement";
	}
}
