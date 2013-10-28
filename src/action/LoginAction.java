package action;

import javax.servlet.http.HttpServletRequest;

import db.BaseDao;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {	
		return "WEB-INF/login.jsp";
	}
}
