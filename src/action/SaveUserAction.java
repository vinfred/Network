package action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import mod.User;
import db.BaseDao;

public class SaveUserAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		Integer id = (Integer)request.getSession().getAttribute("id");
		
		String name  = request.getParameter("name");
		String surname  = request.getParameter("surname");
		String country  = request.getParameter("country");
		String city  = request.getParameter("city");
		String profession  = request.getParameter("profession");
		String interests  = request.getParameter("interests");
		//request.getParameter("birthday");	
		
		Calendar c = Calendar.getInstance();
		c.set(1800, 2, 12);
		System.out.println(c.getTime());
			
		User u = new User (id, country, city, c, interests, profession, name, surname);
		db.updateUser(u);
		
		UserAction act = new UserAction();
		return act.execute(request, db);
	}

}