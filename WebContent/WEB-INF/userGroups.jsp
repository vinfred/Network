<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html> 
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" >
	<link href='http://fonts.googleapis.com/css?family=Bad+Script&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Google Chew::Groups</title>
</head>
<body>
		
	<div class="top">			
		<div class="top-nav">
		<section>
			<div class="logo">Google Chew</div>
			<div class="login"><table >
					<tr><td>
						<%out.print("<a href=\".\\profile\">"+((User)session.getAttribute("loggedUser")).getEmail()+"</a>");%>
					</td></tr>
					<tr><td>
						<a href=".\logOut">Log Out</a>
					</td></tr>				
			</table></div>
		</section>			
		</div>
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
					<table class="newGroup">						
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
				
				<% ArrayList<Group> groups = (ArrayList<Group>)request.getAttribute("groups"); %>
				<table>
				
				<% 	
					if (groups.size()==0) {
						out.print("<h2>No groups yet :'( </h2>\n");
					}
					else {
						out.print("<caption class=\"smallHeading\">My groups</caption>");
						for (Group g: groups) {
							out.print("<tr><td>"+
									"<form action=\"showGroup\" method=\"get\"><input type=\"hidden\" name = \"group\" value=\""+
									g.getId()+"\"><a href=\"javascript:;\" onclick=\"parentNode.submit();\">"+g.getName()+"</a></form> "+
									"</td><td>"+g.getDescription()+ "</td> "
									+"<td> <form action=\"deleteGroup\" method=\"post\">\n<input type=\"hidden\" name = \"group\" value=\""+
									g.getId()+"\">\n<input type=\"submit\" value=\"Delete\" id="+g.getId()
									+ "></form></td><td>\n<form action=\"editGroup\" method=\"post\"><input type=\"hidden\" name = \"group\" value=\""+
									g.getId()+"\"><input type=\"submit\" value=\"Edit\" id="+g.getId()
									+ "></form></td></tr>\n");
							}
					}
				%>
			</table>
							<% ArrayList<Group> allGroups = (ArrayList<Group>)request.getAttribute("all groups"); %>
				<table>
				
				<% 	
					out.print("<caption class=\"smallHeading\">All groups</caption>\n");
					for (Group g: allGroups) {
						out.print("<tr>\n\t<td>"+
								"<form action=\"showGroup\" method=\"post\"><input type=\"hidden\" name = \"group\" value=\""+
								g.getId()+"\"><a href=\"javascript:;\" onclick=\"parentNode.submit();\">"+g.getName()+"</a></form> "+
								"</td>\n\t<td>"+g.getDescription()+ "</td> "
								+"\n\t<td><form action=\"follow\" method=\"post\"><input type=\"hidden\" name = \"group\" value=\""+
										g.getId()+"\"><input type=\"submit\" value=\"Follow\" id="+g.getId()
										+ "></form></td>\n</tr>\n\n");
					}
				%>
			</table>
			</div><!-- end .main -->
	
		</div><!-- end .body -->
		
		
		<footer>
			<p id="text"> .</p>
		</footer><!-- end .footer -->
		
	</div><!-- end .container -->
	
</body>
</html>