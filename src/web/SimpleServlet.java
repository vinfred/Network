package web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionFactory;
import db.BaseDao;
import db.Database;

/**
 * Servlet implementation class SimpleServlet
 */
//@WebServlet("/")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Database db = (Database) getServletContext().getAttribute("db");


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doResponce(request, response);
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doResponce(request, response);

	}

	protected void doResponce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = ((Database) getServletContext().getAttribute("db")).getConnection();
		BaseDao da = new BaseDao(conn);

		Action action = ActionFactory.getAction(request);
		String res = action.execute(request, da);		

		RequestDispatcher rd = request.getRequestDispatcher(res);
		rd.forward(request, response);


	}
}


