package action;

import help.Md5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.*;
import mod.*;

public class LoggedAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loggedUser")==null) {
			String email  = request.getParameter("email");
			String password  = request.getParameter("password");
			User u = db.findUserByEmail(email);
			
			System.out.println(email);
			System.out.println(password);
			
			if (u!=null) {
				System.out.println(Md5.getMd5(password));
				System.out.println(u.getPassword());
				if (Md5.getMd5(password).equals(u.getPassword())) {
					System.out.println ("boo");
					session.setAttribute("loggedUser", u);
					return "WEB-INF/userMain.jsp";
				}
			}			
		}			
			
		return "WEB-INF/login.jsp";
	}

}
