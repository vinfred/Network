package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.Group;
import mod.User;
import db.BaseDao;

public class UserGroupsAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("loggedUser");

		if (u==null) {
			LoginAction act = new LoginAction();
			return act.execute(request, db);
		}
		else {
			ArrayList<Group> groups = db.allUserGroups(u.getId());
			ArrayList<Group> allGroups = db.allGroups();
			request.setAttribute("groups", groups);
			request.setAttribute("all groups", allGroups);

			return "userGroups.jsp";
		}
	}

}
