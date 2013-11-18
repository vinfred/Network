<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" >
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
		
	<div class="top">			
		<center><div class="top-nav">
			<div class="logo">Google Chew</div>
			<div class="login"><table >
					<tr><td>
						<%out.print("<a href=\".\\user\">"+((User)session.getAttribute("loggedUser")).getEmail()+"</a>");%>
					</td></tr>
					<tr><td>
						<a href=".\logOut">Log Out</a>
					</td></tr>				
			</table></div>			
		</div></center>
	</div>
	<div class="container">
	
		<div class="body">
			<div class="sidebar">
				<ul>
					<li><a href=".\profile">Profile </a></li>
					<li><a href=".\myGroups">My groups </a></li>
					<li><a href=".\settings">Settings </a></li>
				</ul>
			</div><!-- end .sidebar -->
			
			<div class="main">
				<form action="addGroup" method="post">
					<table>						
							<tr><td valign="top">
		 						 <input  type="text" name="title" maxlength="50" size="30" placeholder="group title">
							</td></tr>
							<tr><td valign="top">
		 						 <textarea name="description" rows="5" cols="50" placeholder="description"></textarea>
							</td></tr>
							<tr><td>
								 <input type="submit" value="Create group">   
							</td></tr>									
					</table>
				</form>	
				
				<table>
				<% 
					ArrayList<Group> groups = (ArrayList<Group>)request.getAttribute("groups");
					
					for (Group g: groups) {

						out.print("<tr><td><a href=\".\\showGroup\\1\">"+g.getName()+"</a> </td><td>"+g.getDescription()+ "</td> "
								+"<td> <form action=\"deleteGroup\" method=\"post\"><input type=\"hidden\" name = \"id\" value=\""+
								g.getId()+"\"><input type=\"submit\" value=\"Delete\" id="+g.getId()
								+ "></form></td><td><form action=\"editGroup\" method=\"post\"><input type=\"hidden\" name = \"id\" value=\""+
								g.getId()+"\"><input type=\"submit\" value=\"Edit\" id="+g.getId()
								+ "></form></td></tr>\n");
					}
					if (groups.size()==0) {
						out.print("<h2>No groups yet :'( </h2>\n");
					}
				%>
			</table>
			</div><!-- end .main -->
	
		</div><!-- end .body -->
		
		
		<div class="footer">
			<p id="text"> .</p>
		</div><!-- end .footer -->
		
	</div><!-- end .container -->
	
</body>
</html>