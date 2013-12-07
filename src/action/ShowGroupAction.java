package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.Group;
import mod.Message;
import mod.User;
import db.BaseDao;

public class ShowGroupAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("loggedUser");

		String value = request.getParameter("group");
		Integer id = Integer.valueOf(value);
		Group g= db.findGroupById(Integer.valueOf(id));
		ArrayList <Message> mesList = db.getAllMessages(g.getId());

		if ( (u==null) == Boolean.TRUE) {
			LoginAction act = new LoginAction();
			return act.execute(request, db);
		}
		else {
			System.out.println(g.getName());
			request.setAttribute("group", g);
			System.out.println("current group "+g.getId());

			request.setAttribute("messages", mesList);

			return "showGroup.jsp";
		}
	}

}
