<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="styles/main.css">
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" >
	<!-- <LINK href="/home/mirka/workspace/Network/WebContent/WEB-INF/styles/main.css" rel="stylesheet" type="text/css"> -->
	<!-- link rel="icon" href="favicon.ico" type="image/x-icon" /-->
	
	<title>Google Chew::Users</title>
</head>
<body>
		
		<div class="top">			
		<center><div class="top-nav">
			<div class="logo">Goggle Chew</div>		
		</div></center>
	</div>
	<div class="container">
		<div class="header">
			<h1>List of Users </h1>
		</div>
		
		
		<div class="body">
			<table>
				<% 
					ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
					
					for (User e: users) {

						out.print("<tr><td>"+e.getId()+". </td><td>"+e.getEmail()+ "</td><td>"+e.getPassword()+"</td> "
								+"<td> <form action=\"deleteUser\" method=\"post\"><input type=\"hidden\" name = \"id\" value=\""+
								e.getId()+"\"><input type=\"submit\" value=\"Delete\" id="+e.getId()
								+ "></form></td><td><form action=\"editUser\" method=\"post\"><input type=\"hidden\" name = \"id\" value=\""+
								e.getId()+"\"><input type=\"submit\" value=\"Edit\" id="+e.getId()
								+ "></form></td></tr>\n");
					}
					if (users.size()==0) {
						out.print("<h2>Nobody left here :'( </h2>\n");
					}
				%>
			</table>
			<table>
				<form action="addUser" method="post"><tr>
					<td valign="top">
 						 <input  type="text" name="email" maxlength="50" size="30" placeholder="email">
					</td>
					<td valign="top">
 						 <input  type="password" name="password" maxlength="50" size="30" placeholder="password">
					</td>
					<td>
						 <input type="submit" value="Add">   
					</td>
				</tr></form>
				
			</table>
		</div><!-- end .body -->
		
		
		<div class="footer">
			<p id="text">footer</p>
		</div><!-- end .footer -->
		
	</div><!-- end .container -->
	
</body>
</html>
