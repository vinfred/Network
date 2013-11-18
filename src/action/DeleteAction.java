package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.User;
import db.BaseDao;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("loggedUser");

		if (u==null) {
			LoginAction act = new LoginAction();
			return act.execute(request, db);
		} 
		else {
			String value = request.getParameter("id");
			Integer id = Integer.valueOf(value);

			db.deleteUser(db.findUserById(Integer.valueOf(id)));

			UserAction act = new UserAction();
			return act.execute(request, db);
		}
	}
}
