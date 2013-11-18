package action;

import help.Md5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.User;
import db.BaseDao;

public class LoggedAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		UserMainAction act = new UserMainAction();
		HttpSession session = request.getSession();
		User u = null;

		if (session.getAttribute("loggedUser")!=null) {
			return act.execute(request, db);
		} 
		else {

			//System.out.println ("first if");
			String email  = request.getParameter("email");
			String password  = request.getParameter("password");
			u = db.findUserByEmail(email);

			System.out.println(email);
			System.out.println(password);

			if (u!=null) {
				//System.out.println ("second if");
				//System.out.println(Md5.getMd5(password));
				//System.out.println(u.getPassword());
				if (Md5.getMd5(password).equals(u.getPassword())) {
					//System.out.println ("third if");
					//temporary decision - 18/11/2013
					//u=db.findUserById(u.getId());
					session.setAttribute("loggedUser", u);
					System.out.println(u.getName());
					System.out.println(session.getAttribute("loggedUser"));
					request.setAttribute("user", u);

					return act.execute(request, db);
				} else {
					return "WEB-INF/login.jsp";
				}
			} 

			else {
				return "login.jsp";
			}
		}
	}

}
