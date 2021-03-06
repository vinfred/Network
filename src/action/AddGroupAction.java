package action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.Group;
import mod.User;
import db.BaseDao;

public class AddGroupAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("loggedUser");

		if (u==null) {
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
			String title  = request.getParameter("title");
			String description  = request.getParameter("description");
			System.out.println(title);
			Group g = new Group(u, title, description);
			db.createGroup(g);


			UserGroupsAction act = new UserGroupsAction();
			return act.execute(request, db);
		}		
	}
}
