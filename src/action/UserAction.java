package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import mod.User;
import db.BaseDao;

public class UserAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		//BaseDao db = new BaseDao(connection);
		ArrayList<User> users = db.allUsers();
		
		request.setAttribute("users", users);
		return "WEB-INF/jsp.jsp";
	}

}
