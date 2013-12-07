package action;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.Group;
import mod.Message;
import mod.User;
import db.BaseDao;

public class AddMessageAction implements Action {

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
			Calendar c = Calendar.getInstance();

			//c.set(1800, Calendar.JULY, 12);

			String value = request.getParameter("group");
			Integer id = Integer.valueOf(value);
			//Group g = (Group)request.getAttribute("current group");
			Group g = db.findGroupById(id);
			System.out.println(g.getId());

			String text  = request.getParameter("text");
			System.out.println(text);
			Message m = new Message (u, text, c);
			db.createMessage(m, g);

			//request.setAttribute(text, g);
			ShowGroupAction act = new ShowGroupAction();
			return act.execute(request, db);
		}
	}
}
