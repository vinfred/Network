package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.Group;
import mod.User;
import db.BaseDao;

public class EditGroupAction implements Action {

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
			Group g = db.findGroupById(id);
			request.getSession().setAttribute("group id", id);
			session.setAttribute("group", g);

			return "editGroup.jsp";
		}

	}
}