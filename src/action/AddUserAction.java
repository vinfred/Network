package action;

import javax.servlet.http.HttpServletRequest;

import mod.User;
import db.BaseDao;

public class AddUserAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		String email  = (String)request.getParameter("email");
		String password  = (String)request.getParameter("password");
		
		System.out.println("email: "+email);
		
		User u = new User (email, password);
		db.createUser(u);
		
		UserAction act = new UserAction();
		return act.execute(request, db);
	}

}
