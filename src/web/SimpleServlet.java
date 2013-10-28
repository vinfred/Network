package web;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import action.*;
import db.*;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("//*")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Database db = (Database) getServletContext().getAttribute("db");


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doResponce(request, response);

	}	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

 
