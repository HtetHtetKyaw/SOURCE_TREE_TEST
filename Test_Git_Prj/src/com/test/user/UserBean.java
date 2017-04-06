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

	private String firstName;
	
	private String secondName;

	@PostConstruct
	public void init() {
		firstName = "Nakamoto";
		secondName = "Yuta Jeno";
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
}