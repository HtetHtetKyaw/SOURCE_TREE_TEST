/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mutu.newdev.web.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class BootStrap implements ServletContextListener {
	private static Logger logger = Logger.getLogger(BootStrap.class);

	public void contextInitialized(ServletContextEvent sce) {
		logger.info("Initialization has been started...................");
		logger.info("Initilization has been fiished......................");
	}
	public void contextDestroyed(ServletContextEvent sce) {
	}
}