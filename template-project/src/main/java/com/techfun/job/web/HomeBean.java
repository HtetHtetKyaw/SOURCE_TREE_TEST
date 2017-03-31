package com.techfun.job.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.techfun.job.entity.JobCategory;
import com.techfun.job.entity.JobDetail;
import com.techfun.job.service.HomeService;

@ManagedBean(name = "HomeBean")
@ViewScoped
public class HomeBean implements Serializable {

	/**  */
	private static final long serialVersionUID = 1L;

	private List<JobDetail> jobList;
	private List<JobCategory> jobCategoryList;
	private Integer jobCategoryId;
	private String selectedCategoryName;
	private JobDetail selectedJob;
	private String searchKeyWord;
	private int statusFlag;

	@ManagedProperty(value = "#{HomeService}")
	private HomeService homeService;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	@PostConstruct
	public void init() {

		jobCategoryList = new ArrayList<JobCategory>();
		jobCategoryId = 0;
		searchKeyWord = "";
		jobList = new ArrayList<JobDetail>();
		/*jobCategoryList = homeService.selectJobCategoryList();
		FacesContext context = FacesContext.getCurrentInstance();
		if ((Integer) context.getExternalContext().getFlash().get("flash_job_categoryId") != null) {
			jobCategoryId = (Integer) context.getExternalContext().getFlash().get("flash_job_categoryId");
			getSelectedJobList();
		} else if ((String) context.getExternalContext().getFlash().get("flash_job_searchKeyWord") != null) {
			searchKeyWord = (String) context.getExternalContext().getFlash().get("flash_job_searchKeyWord");
			processSearch();
		} else {
			jobList = homeService.selectJobList(0);
		}*/
	}

	public List<JobDetail> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobDetail> jobList) {
		this.jobList = jobList;
	}

	public List<JobCategory> getJobCategoryList() {
		return jobCategoryList;
	}

	public void setJobCategoryList(List<JobCategory> jobCategoryList) {
		this.jobCategoryList = jobCategoryList;
	}

	public Integer getJobCategoryId() {
		return jobCategoryId;
	}

	public void setJobCategoryId(Integer jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}

	public String getSelectedCategoryName() {
		return selectedCategoryName;
	}

	public void setSelectedCategoryName(String selectedCategoryName) {
		this.selectedCategoryName = selectedCategoryName;
	}

	public JobDetail getSelectedJob() {
		return selectedJob;
	}

	public void setSelectedJob(JobDetail selectedJob) {
		this.selectedJob = selectedJob;
	}

	public String getSearchKeyWord() {
		return searchKeyWord;
	}

	public void setSearchKeyWord(String searchKeyWord) {
		this.searchKeyWord = searchKeyWord;
	}

	public Integer getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(Integer statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getSelectedJobList() {

		statusFlag = 1;
		jobList = homeService.selectJobList(jobCategoryId);
		int index = 0;
		for (int i = 0; i < jobCategoryList.size(); i++) {
			if (jobCategoryList.get(i).getJobCategoryId() == jobCategoryId) {
				index = i;
				break;
			}
		}
		selectedCategoryName = jobCategoryList.get(index).getJobCategoryName();
		return null;
	}

	public String processDetail() {

		/*
		 * System.out.println("Job Title " + selectedJob.getPostTitle());
		 * System.out.println("job category Id" + jobCategoryId);
		 */
		if (statusFlag == 1 || statusFlag == 0) {
			searchKeyWord = null;
		} else if (statusFlag == 2) {
			jobCategoryId = null;
		}
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_job", selectedJob);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_job_categoryId", jobCategoryId);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_job_searchKeyWord", searchKeyWord);
		return "jobDetails";
	}

	public void processSearch() {

		statusFlag = 2;
		jobList = homeService.searchJobList(searchKeyWord);
		selectedCategoryName = "Searching for '" + searchKeyWord + "'";
	}

	public String processLogin() {

		return "login";
	}
}
