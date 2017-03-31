package com.techfun.job.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpSession;

import com.techfun.job.entity.JobDetail;
import com.techfun.job.service.UserManageService;

@ManagedBean(name = "UserManageBean")
@ViewScoped
public class UserManageBean {

	private List<JobDetail> jobList;
	private JobDetail selectedJob;
	private Integer selectedJobCategory;

	@ManagedProperty("#{UserManageService}")
	private UserManageService service;
	
	private HttpSession session = SessionBean.getSession();

	@PostConstruct
	public void init() {

		if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_jobCategoryId") != null) {
			selectedJobCategory = (Integer) FacesContext.getCurrentInstance().getExternalContext().getFlash()
					.get("flash_jobCategoryId");
			onJobCategoryChange();
		} else {
			jobList = service.getJobList((Integer) session.getAttribute("userId"), null);
		}
	}

	public List<JobDetail> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobDetail> jobList) {
		this.jobList = jobList;
	}

	public JobDetail getSelectedJob() {
		return selectedJob;
	}

	public void setSelectedJob(JobDetail selectedJob) {
		this.selectedJob = selectedJob;
	}

	public void setService(UserManageService service) {
		this.service = service;
	}

	public Integer getSelectedJobCategory() {
		return selectedJobCategory;
	}

	public void setSelectedJobCategory(Integer selectedJobCategory) {
		this.selectedJobCategory = selectedJobCategory;
	}

	public String processDetail() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_job", selectedJob);
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("flash_jobCategoryId", selectedJobCategory);
		return "userJobDetail";
	}

	public String processLogOut() {

		HttpSession session = SessionBean.getSession();
        session.invalidate();
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "home";
	}

	public String processNewPost() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("flash_jobCategoryId", selectedJobCategory);
		return "newPost";
	}

	public String onJobCategoryChange() {

		if (selectedJobCategory == 0) {
			selectedJobCategory = null;
		}
		jobList = service.getJobList((Integer) session.getAttribute("userId"), selectedJobCategory);
		return null;
	}

	public String processEditJob() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("edit_job", selectedJob);
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put("flash_jobCategoryId", selectedJobCategory);
		return "editPost";
	}

	public String processDeleteJob() {

		String msg = null;
		int result = service.deleteJob(selectedJob.getJobId());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		if (result == 1) {
			msg = "Successfully delete selected job.";
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		} else {
			msg = "Failed to delete selected job.";
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
		return "userJobManagement";
	}
}
