package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import db.Database;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		 
    	String url = sc.getInitParameter("url");
    	String user = sc.getInitParameter("user");
    	String password = sc.getInitParameter("password");
    	String database = sc.getInitParameter("database");
    	Database db = new Database(url + database, user, password);
    	//System.out.println("in the listener!!");
    	sc.setAttribute("db", db);
		
		
	}

}
