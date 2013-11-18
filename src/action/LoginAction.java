package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.BaseDao;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {	
		HttpSession session = request.getSession();
		UserMainAction act = new UserMainAction();
		System.out.println("login action");
		if (session.getAttribute("loggedUser")!=null) {
			return act.execute(request, db);
		} 
		else {
			return "login.jsp";
		}

	}
}
