package action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.User;
import db.BaseDao;

public class SaveUserAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		Integer id = (Integer)session.getAttribute("id");
		User lUser = (User)session.getAttribute("loggedUser");

		String name  = request.getParameter("name");
		String surname  = request.getParameter("surname");
		String country  = request.getParameter("country");
		String city  = request.getParameter("city");
		String profession  = request.getParameter("profession");
		String interests  = request.getParameter("interests");
		//request.getParameter("birthday");	

		Calendar c = Calendar.getInstance();
		c.set(1800, Calendar.JULY, 12);

		User u = new User (id, lUser.getEmail(), lUser.getPassword(), 
				country, city, c, interests, profession, name, surname);
		db.updateUser(u);

		session.setAttribute("loggedUser", u);
		UserMainAction act = new UserMainAction();
		return act.execute(request, db);
	}

}