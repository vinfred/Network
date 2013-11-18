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
			for (Group g: groups) {
				System.out.println(g.getName());
			}
			System.out.println("chew");

			request.setAttribute("groups", groups);

			return "userGroups.jsp";
		}
	}

}
