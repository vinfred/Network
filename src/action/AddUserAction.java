package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.User;
import db.BaseDao;

public class AddUserAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();

		String email  = request.getParameter("email");
		String password  = request.getParameter("password");

		System.out.println("email: "+email);

		if ((email!=null) && (password!=null) && !email.equals("") && !password.equals("")) {
			User u = new User (email, password);
			db.createUser(u);
			u = db.findUserByEmail(u.getEmail());
			session.setAttribute("loggedUser", u);

			UserMainAction act = new UserMainAction();
			return act.execute(request, db);
		}
		else {
			LoginAction act = new LoginAction();
			return act.execute(request, db);
		}
	}
}
