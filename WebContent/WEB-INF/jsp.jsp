<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="CAontent-Type" content="text/html; charset=UTF-8">
	<%
	//String url = request.getContextPath() + "/WebContent/styles/main.css";
	//out.println("<link href=\"main.css\" rel=\"stylesheet\" type=\"text/css\">");
	%>
	<%
	out.println("<style type=\"text/css\">");
	FileInputStream fis = new FileInputStream(new File("/home/mirka/workspace/Network/WebContent/styles/main.css"));
	byte[] buff = new byte[26400];
	String res = "";
	try {
		fis.read(buff);
		res = new String(buff);
	}
	catch (Exception ex ) {ex.printStackTrace();};
	
	out.println(res);
	out.println("</style>");
	%>
	<!-- <LINK href="/home/mirka/workspace/Network/WebContent/WEB-INF/styles/main.css" rel="stylesheet" type="text/css"> -->
	<link rel="icon" href="favicon.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
	<title>Google Chew::Users</title>
</head>
<body>
		
	<div class="top">			
		<table class="top-nav">
			<tr>
				<td id="text">Goggle Chew</td>
				<td><table id="login"><tr>
					<td>Panasik</td>
					<td>Chewchewuskas</td>
				</tr></table></td>					
			</tr>
		</table>
	</div>
	<div class="container">
		<div class="header">
			<h1>List of Users </h1>
		</div>
		
		
		<div class="body">
			<table>
				<% 
					BaseDao db = new BaseDao();
					ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
					
					for (User e: users) {

						out.print("<tr><td>"+e.getId()+". </td><td>"+e.getName()+ "</td><td>"+e.getSurname()+"</td> "
								+"<td> <form action=\"deleteUser\" method=\"post\"><input type=\"hidden\" name = \"id\" value=\""+
								e.getId()+"\"><input type=\"submit\" value=\"Delete\" id="+e.getId()
								+ "></form></td><td><form action=\"EditUser\" method=\"post\"><input type=\"hidden\" name = \"id\" value=\""+
								e.getId()+"\"><input type=\"submit\" value=\"Edit\" id="+e.getId()
								+ "></form></td></tr>\n");
					}
					if (users.size()==0) {
						out.print("<h2>Nobody left here :'( </h2>\n");
					}
				%>
			</table>
		</div><!-- end .body -->
		
		
		<div class="footer">
			<p id="text">footer</p>
		</div><!-- end .footer -->
		
	</div><!-- end .container -->
	
</body>
</html>