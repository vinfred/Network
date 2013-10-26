package action;

import javax.servlet.http.HttpServletRequest;

import db.BaseDao;

public interface Action {
	public String execute (HttpServletRequest request, BaseDao db);
}
