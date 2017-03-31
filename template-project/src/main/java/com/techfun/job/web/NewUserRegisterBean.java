package com.techfun.job.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

import com.techfun.job.dto.UserDto;
import com.techfun.job.entity.User;
import com.techfun.job.service.NewUserRegisterService;

@ManagedBean(name = "NewUserRegisterBean")
@ViewScoped
public class NewUserRegisterBean {

	private User user;
	private UserDto dto;

	@ManagedProperty("#{NewUserRegisterService}")
	private NewUserRegisterService service;

	@PostConstruct
	public void init() {

		if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_user") != null) {
			dto = (UserDto) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_user");
			/*user = (User) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_user");*/
		} else {
			user = new User();
			dto = new UserDto();
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setService(NewUserRegisterService service) {
		this.service = service;
	}

	public UserDto getDto() {
		return dto;
	}

	public void setDto(UserDto dto) {
		this.dto = dto;
	}

	public String processBack() {
		return "login";
	}

	public String processContinuous() throws Exception {

		UploadedFile uploadPhoto = dto.getImage();
		String name = dto.getImage().getFileName();
	    System.out.println("File name: " + name);

	    String type = dto.getImage().getContentType();
	    System.out.println("File type: " + type);

	    long size = dto.getImage().getSize();
	    System.out.println("File size: " + size);
	    
	 // obtains file path of uploadPhoto
	    ServletContext servletContext = (ServletContext) FacesContext
			    .getCurrentInstance().getExternalContext().getContext();
				
	        String tmpFilePath = servletContext.getRealPath("/tmpImage/")+"\\";
			System.out.println(tmpFilePath);
			
			byte[] bytes=null;
			String fileName = null;
			if (null != uploadPhoto) {
				bytes = uploadPhoto.getContents();
				fileName = FilenameUtils.getName(uploadPhoto.getFileName());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(tmpFilePath+fileName)));
				stream.write(bytes);
				stream.close();
			}
		dto.setFileName(fileName);
	    FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_user", dto);
		/*FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_user", user);*/
		return "newUserRegisterConf";
	}

	public void checkDuplicateUsername() {

		int count = service.checkUsername(dto.getUsername());
		if (count == 1) {
			String msg = "UserName [" + dto.getUsername() + "] already in use.";
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("newUserRegisterForm:username", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
/*		int count = service.checkUsername(user.getUsername());
		if (count == 1) {
			String msg = "UserName [" + user.getUsername() + "] already in use.";
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("newUserRegisterForm:username", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}*/
	}
}
