package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.User;
import db.BaseDao;

public class LogOutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {	
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("loggedUser");

		if (u==null) {
			LoginAction act = new LoginAction();
			return act.execute(request, db);
		} 
		else {
			System.out.println("log out action");
			session.removeAttribute("loggedUser");

			return "login.jsp";
		}		
	}
}
