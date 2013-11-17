package action;

import javax.servlet.http.HttpServletRequest;

import db.BaseDao;

public class UserMainAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		// TODO Auto-generated method stub
		return "WEB-INF/userMain.jsp";
	}

}
