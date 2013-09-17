package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mod.User;
import db.BaseDao;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet/*")
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SimpleServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseDao db = new BaseDao();
		User u = db.findUserById(2);
		ArrayList<User> users = db.allUsers();
		PrintWriter pw = response.getWriter();
		
		
		pw.write("<html><head><title>Chew Chew </title></head> \n");	
		pw.write("<body bgcolor=\"pink\">\n\n");
		pw.write("<h1>List of Users </h1>\n");
		
		pw.write("<table>\n");
		for (User e: users) {
			pw.write("<tr><td>"+e.getId()+"</td><td>"+e.getName()+ "</td><td>"+e.getSurname()+"</td> "
					+"<td> <form action=\"DeleteUser\" method=POST> Edit User</button> </td></tr>\n");
		}
		pw.write("</table>\n");
		
		pw.write("\n</body></html>\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	

}
