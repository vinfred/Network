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
			</div>
			
			<div class="main">
				<%User u = (User)session.getAttribute("loggedUser");%>
				<form action="editUser" method="post">
				<input type="hidden" name = "id" value="<%out.print(u.getId()); %>">
				<table>
					<tr>
						<td valign="top"><label for="name"><i>Name</i></label></td>
						<td valign="top"><span><%out.print(u.getName()==null?"":u.getName()); %></span></td>
					</tr>
					<tr>
						<td valign="top"><label for="surname"><i>Surname</i></label></td>
 						<td valign="top"><%out.print(u.getSurname()==null?"":u.getSurname()); %></td>
					</tr>
					<tr>
						<td valign="top"><label for="birthday"><i>Birthday</i></label></td>
						<td valign="top"><% %></td>
					</tr>
					<tr></tr>
					<tr>
						<td valign="top"><label for="country"><i>Country</i></label></td>
						<td valign="top"><%out.print(u.getCountry()==null?"":u.getCountry()); %></td>
					</tr>
					<tr>
						<td valign="top"><label for="city"><i>City</i></label></td>
 						<td valign="top"><%out.print(u.getCity()==null?"":u.getCity()); %></td>
					</tr>
					<tr>
						<td valign="top"><label for="profession"><i>Profession</i></label></td>
						<td valign="top"><%out.print(u.getProfession()==null?"":u.getProfession()); %></td>
					</tr>
					
					<tr>
						<td valign="top"><label for="interests"><i>Interests</i></label></td>
						<td valign="top"><%out.print(u.getInterests()==null?"":u.getInterests()); %></td>
						
					</tr>
					<tr><td>
						 <input type="submit" value="Edit info">   
					</td></tr>				
			</table>
			</form>
				
			</div>
	
		</div><!-- end .body -->
		
		
		<div class="footer">
			<p id="text">footer</p>
		</div><!-- end .footer -->
		
	</div><!-- end .container -->
	
</body>
</html>