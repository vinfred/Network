<%@page import="org.apache.catalina.ant.FindLeaksTask"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html> 
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" >
	<link href='http://fonts.googleapis.com/css?family=Bad+Script&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Google Chew::Edit Group</title>
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
			<%Group g = (Group)session.getAttribute("current group");%>
				<form action="saveGroup" method="post">
					<table class="newGroup">						
							<tr><td valign="top">
		 						 <input  type="text" name="title" maxlength="50" size="30" placeholder="group title" value="<%out.print(g.getName());%>">
							</td></tr>
							<tr><td valign="top">
		 						 <textarea name="description" rows="5" cols="50" placeholder="description"><%out.print(g.getDescription());%></textarea>
							</td></tr>
							<tr><td>
								 <input type="submit" value="Save group">   
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