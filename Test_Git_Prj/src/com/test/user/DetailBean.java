/**
 * @author techfunmmr
 *
 */
package com.test.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "DetailBean")
// @RequestScoped
@SessionScoped
public class DetailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Integer age;

	@PostConstruct
	public void init() {
		name = "Nakamoto Yuta";
		age = 22;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

}