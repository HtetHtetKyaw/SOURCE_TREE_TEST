/**
 * @author techfunmmr
 *
 */
package com.test.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "UserBean")
// @RequestScoped
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	@PostConstruct
	public void init() {
		name = "Donghae";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}