package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mod.Group;
import mod.Message;
import mod.User;
import db.BaseDao;

public class DeleteMessageAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("loggedUser");

		if (u==null) {
			LoginAction act = new LoginAction();
			return act.execute(request, db);
		}
		else {
			String value = request.getParameter("message");
			Integer id = Integer.valueOf(value);
			Message m = db.findMessageById(Integer.valueOf(id));
			System.out.println("message text: "+m.getText());
			db.deleteMessage(m);

			Group g = db.findMessageGroup(m);
			//request.setParameter("group", g.getId());
			ShowGroupAction act = new ShowGroupAction();
			return act.execute(request, db);
		}	
	}

}
