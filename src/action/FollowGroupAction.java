package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.User;
import db.BaseDao;

public class FollowGroupAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loggedUser");

		if (user==null) {
			LoginAction act = new LoginAction();
			return act.execute(request, db);
		}
		else {
			String value = request.getParameter("group");
			Integer id = Integer.valueOf(value);
			System.out.println(id);
			db.addUserToGroup(user, db.findGroupById(id));

			UserGroupsAction act = new UserGroupsAction();
			return act.execute(request, db);
		}
	}

}
