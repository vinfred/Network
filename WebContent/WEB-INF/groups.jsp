<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html> 
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" >
	<link href='http://fonts.googleapis.com/css?family=Bad+Script&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Google Chew::Group</title>
</head>
<body>
		
	<div class="top">			
		<center><div class="top-nav">
			<div class="logo">Google Chew</div>
			<div class="login"><table >
					<tr><td>
						<%out.print("<a href=\".\\profile\">"+((User)session.getAttribute("loggedUser")).getEmail()+"</a>");%>
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
				<%Group g  = (Group)request.getAttribute("current group");%>
				<form action="editUser" method="post">	
				<table>
					<tr>
						<td valign="top"><label for="name"><i>Title</i></label></td>
						<td valign="top"><span><%out.print(g.getName()==null?"":g.getName()); %></span></td>
					</tr>
					<tr>
						<td valign="top"><label for="description"><i>Description</i></label></td>
 						<td valign="top"><%out.print(g.getDescription()==null?"":g.getDescription()); %></td>
					</tr>
					<tr><td>
						 <input type="submit" value="Edit group">   
					</td></tr>
				</table>
				</form>
			</div><!-- end .main -->
	
		</div><!-- end .body -->
		
		
		<footer>
			<p id="text"> .</p>
		</footer><!-- end .footer -->
		
	</div><!-- end .container -->
	
</body>
</html>