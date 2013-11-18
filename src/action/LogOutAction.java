package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.BaseDao;

public class LogOutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {	
		HttpSession session = request.getSession();
		System.out.println("log out action");
		session.removeAttribute("loggedUser");

		return "WEB-INF/login.jsp";
	}
}
