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
import javax.faces.context.Flash;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.UploadedFile;

import com.techfun.job.dto.UserDto;
import com.techfun.job.entity.User;
import com.techfun.job.service.NewUserRegisterConfirmService;

@ManagedBean(name = "NewUserRegisterConfBean")
@ViewScoped
public class NewUserRegisterConfBean {

	private UserDto dto;
	
	@ManagedProperty("#{NewUserRegisterConfirmService}")
	private NewUserRegisterConfirmService service;

	@PostConstruct
	public void init() {

		this.dto = (UserDto) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_user");
		/*this.user = (User) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("flash_user");*/
	}

	public void setService(NewUserRegisterConfirmService service) {
		this.service = service;
	}

	public UserDto getDto() {
		return dto;
	}

	public void setDto(UserDto dto) {
		this.dto = dto;
	}

	public String processBack() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_user", dto);
		/*FacesContext.getCurrentInstance().getExternalContext().getFlash().put("flash_user", user);*/
		return "newUserRegister";
	}

	public String processRegister() throws Exception {

		String msg = null;
		String page = null;
		/** Write upload file */
		// obtains file path of uploadPhoto
		UploadedFile uploadPhoto = dto.getImage();
	    ServletContext servletContext = (ServletContext) FacesContext
			    .getCurrentInstance().getExternalContext().getContext();
				
			String filePath = servletContext.getRealPath("/UploadImage/")+"\\";
			System.out.println(filePath);
			
			byte[] bytes=null;
			String fileName = null;
			if (null != uploadPhoto) {
				bytes = uploadPhoto.getContents();
				fileName = FilenameUtils.getName(uploadPhoto.getFileName());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+fileName)));
				stream.write(bytes);
				stream.close();
			}
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setUploadFile(dto.getFileName());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		user.setPhoneno(dto.getPhoneno());
		user.setDob(dto.getDOB());
		user.setAddress(dto.getAddress());
		int result = service.insertUser(user);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Flash flash = facesContext.getExternalContext().getFlash();
		flash.setKeepMessages(true);
		flash.setRedirect(true);
		if (result == 1) {
			msg = "New user was successfully registered.";
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
			user.setUserId(service.getLastInsertedId(user.getUsername()));
			HttpSession session = SessionBean.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userId", user.getUserId());
			page = "userJobManagement";
		} else {
			msg = "Failed to register new user.";
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
			page = "login";
		}
		return page;
	}
}
