package action;

import javax.servlet.http.HttpServletRequest;

import db.BaseDao;

public class DeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, BaseDao db) {
		//BaseDao db = new BaseDao();
		String value = (String)request.getParameter("id");
		Integer id = Integer.valueOf(value);

		db.deleteUser(db.findUserById(Integer.valueOf(id)));
		
		UserAction act = new UserAction();
		return act.execute(request, db);
	}

}
