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

import mod.User;
import mod.UserDao;
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
		RequestDispatcher RD = getServletContext().getRequestDispatcher("/DeleteUser");  
		request.setAttribute("param", 5);
		RD.forward(request, response);
		//db.deleteUser(db.findUserById(3));  

	}	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<User> users = db.allUsers();
		PrintWriter pw = response.getWriter();
		
		
		pw.write("<html><head><title>Chew Chew </title>\n");	
		pw.write("<body bgcolor=\"pink\">\n\n");		
		
		pw.write("<h1>List of Users </h1>\n");
		
		pw.write("<table>\n");
		for (User e: users) {
		//	pw.write("<tr><td>"+e.getId()+"</td><td>"+e.getName()+ "</td><td>"+e.getSurname()+"</td> "
				//	+"<td> <form method=POST action =\"\">"
					//		+ "<INPUT TYPE=\"submit\" value=\"Delete\"></form> </td></tr>\n");
			pw.write("<tr><td>"+e.getId()+"</td><td>"+e.getName()+ "</td><td>"+e.getSurname()+"</td> "
					+"<td> <form action=\"\" method=\"post\"><input type=\"submit\" value=\"submit\"></form></td></tr>\n");

			
		}
		pw.write("</table>\n");
		
		pw.write("\n</body></html>\n");
		


	}
}

 