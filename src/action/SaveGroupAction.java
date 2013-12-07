package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.Group;
import mod.User;
import db.BaseDao;

public class SaveGroupAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loggedUser");

		if (user==null) {
			LoginAction act = new LoginAction();
			return act.execute(request, db);
		}
		else {
			try {
				request.setCharacterEncoding("UTF-8");
			}
			catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			Integer id = (Integer)session.getAttribute("group");
			User lUser = (User)session.getAttribute("loggedUser");

			String name  = request.getParameter("title");
			String description  = request.getParameter("description");


			Group g = new Group(id, lUser, name, description);
			db.updateGroup(g);

			//session.setAttribute("loggedUser", u);
			UserGroupsAction act = new UserGroupsAction();
			return act.execute(request, db);
		}

	}}
