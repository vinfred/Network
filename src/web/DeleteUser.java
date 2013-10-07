package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.BaseDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser/*")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BaseDao db = new BaseDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doResponce(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doResponce(request, response);
	}
	
	protected void doResponce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();		
		pw.write("hopeless");	
		
		String value = (String)request.getParameter("id");
		Integer id = Integer.valueOf(value);

		db.deleteUser(db.findUserById(Integer.valueOf(id)));  
		
		RequestDispatcher RD = request.getRequestDispatcher("chew");  
		RD.forward(request, response); 
	}

}
