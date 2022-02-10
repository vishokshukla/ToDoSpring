package com.l;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entities.ToDo;

public class MyListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Context Created!");
		List<ToDo> list = new ArrayList<ToDo>();
		
		ServletContext context = sce.getServletContext();
		context.setAttribute("list", list);
	}

	
}
