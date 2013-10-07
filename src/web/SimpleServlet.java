package web;

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


import db.*;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet/*")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BaseDao db = new BaseDao();
    /**
     * Default constructor. 
     */
    public SimpleServlet() {
        // TODO Auto-generated constructor stub
    }
    

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
		RequestDispatcher rd = request.getRequestDispatcher("jsp.jsp");
		rd.forward(request, response);
		
	/*	ArrayList<User> users = db.allUsers();
		PrintWriter pw = response.getWriter();
		
		
		pw.write("<html><head><title>Chew Chew </title>\n");	
		pw.write("<body bgcolor=\"pink\">\n\n");		
		
		pw.write("<h1>List of Users </h1>\n");
		
		pw.write("<table>\n");
		for (User e: users) {

			pw.write("<tr><td>"+e.getId()+"</td><td>"+e.getName()+ "</td><td>"+e.getSurname()+"</td> "
					+"<td> <form action=\"DeleteUser\" method=\"post\"><input type=\"hidden\" name = \"id\" value=\""+
					e.getId()+"\"><input type=\"submit\" value=\"Delete\" id="+e.getId()
					+ "></form></td></tr>\n");			
		}
		
		if (users.size()==0) {
			pw.write("<h2>Nobody left here :'( </h2>\n");
		}
		
		pw.write("</table>\n");
		
		pw.write("\n</body></html>\n");	*/	

	}
}

 