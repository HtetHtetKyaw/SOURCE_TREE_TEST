package com.techfun.job.web.common;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.context.RequestContext;


public class BaseBean {

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	protected Application getApplicationContext() {
		return getFacesContext().getApplication();
	}

	protected Map getRequestMap() {
		return getFacesContext().getExternalContext().getRequestMap();
	}

	protected ResourceBundle getBundle() {
		return ResourceBundle.getBundle(getApplicationContext().getMessageBundle(), getFacesContext().getViewRoot().getLocale());
	}

	protected String getSystemPath() {
		Object context = FacesContext.getCurrentInstance().getExternalContext().getContext();
		String systemPath = ((ServletContext) context).getRealPath("/");
		return systemPath;
	}

	protected String getMessage(String id, Object... params) {
		String text = null;
		try {
			text = getBundle().getString(id);
		} catch (MissingResourceException e) {
			text = "!! key " + id + " not found !!";
		}
		if (params != null) {
			MessageFormat mf = new MessageFormat(text);
			text = mf.format(params, new StringBuffer(), null).toString();
		}
		return text;
	}

	protected void addWranningMessage(String id, String errorCode, Object... params) {
		String message = getMessage(errorCode, params);
		getFacesContext().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_WARN, message, ""));
	}

	protected void addInfoMessage(String id, String errorCode, Object... params) {
		String message = getMessage(errorCode, params);
		getFacesContext().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
	}

	protected void addErrorMessage(String id, String errorCode, Object... params) {
		String message = getMessage(errorCode, params);
		getFacesContext().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	protected void addErrorMessage(String message) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	protected void addInfoMessage(String message) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}

	protected void addWranningMessage(String message) {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
	}

	protected void addErrorByMessage(String id, String message) {
		getFacesContext().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	protected void addInfoByMessage(String id, String message) {
		getFacesContext().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}

	protected void addWranningByMessage(String id, String message) {
		getFacesContext().addMessage(id, new FacesMessage(FacesMessage.SEVERITY_WARN, message, message));
	}

	protected void putParam(String key, Object obj) {
		getRequestMap().put(key, obj);
	}

	protected Object getParam(String key) {
		return getRequestMap().get(key);
	}

	protected Map<String, Object> dialogOptions;
	
	protected Map<String, Object> getDialogOption() {
		if (dialogOptions == null) {
			dialogOptions = new HashMap<String, Object>();
			dialogOptions.put("modal", true);
			dialogOptions.put("draggable", false);
			dialogOptions.put("resizable", false);
			dialogOptions.put("contentHeight", 600);
			dialogOptions.put("contentWidth", 700);
		}
		return dialogOptions;
	}
	
	protected void openDialog(String dialog, boolean singleSelection) {
		putParam("singleSelection", singleSelection);
		RequestContext.getCurrentInstance().openDialog(dialog, getDialogOption(), null);
	}
}
