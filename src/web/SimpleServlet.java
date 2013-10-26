package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionFactory;
import db.*;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("//*")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BaseDao db = new BaseDao();

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

			Action action = ActionFactory.getAction(request);
			String res = action.execute(request);		
		
			RequestDispatcher rd = request.getRequestDispatcher(res);
			rd.forward(request, response);
		

	}
}

 