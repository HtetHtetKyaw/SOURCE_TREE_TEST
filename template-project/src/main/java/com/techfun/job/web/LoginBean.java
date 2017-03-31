package com.techfun.job.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import com.techfun.job.dto.LoginDto;
import com.techfun.job.entity.User;
import com.techfun.job.service.LoginService;

@ManagedBean(name = "LoginBean")
@ViewScoped
public class LoginBean {

	private List<User> loginUserList;
	private LoginDto loginDto;
	private String loginStatus;

	@ManagedProperty(value = "#{LoginService}")
	private LoginService loginService;

	@PostConstruct
	public void init() {
		loginDto = new LoginDto();
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public LoginDto getLoginDto() {
		return loginDto;
	}

	public void setLoginDto(LoginDto loginDto) {
		this.loginDto = loginDto;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public List<User> getLoginUserList() {
		return loginUserList;
	}

	public void setLoginUserList(List<User> loginUserList) {
		this.loginUserList = loginUserList;
	}

	public String processLogin() {

		String page = null;
		loginUserList = loginService.getLoginUser(loginDto);
		if (loginUserList.size() == 0) {
			loginStatus = "Login failed. Username and Password doesn't matched.";
		} else {
			page = "userJobManagement";
			HttpSession session = SessionBean.getSession();
			session.setAttribute("username", loginUserList.get(0).getUsername());
			session.setAttribute("userId", loginUserList.get(0).getUserId());
		}
		return page;
	}

	public String processBack() {
		return "home";
	}

	public String processNewUserRegister() {
		return "newUserRegister";
	}
}
