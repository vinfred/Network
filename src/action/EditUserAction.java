package action;

import javax.servlet.http.HttpServletRequest;

import db.BaseDao;

public class EditUserAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		String value = request.getParameter("id");
		Integer id = Integer.valueOf(value);
		
		request.getSession().setAttribute("id", id);
		
		return "WEB-INF/editUser.jsp";
	}

}
