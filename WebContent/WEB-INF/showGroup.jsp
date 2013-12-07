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
		<div class="top-nav">
		<section>
			<div class="logo"><p>Google Chew</p></div>
			<div class="login"><table >
					<tr><td>
						<%out.print("<a href=\".\\profile\">"+((User)session.getAttribute("loggedUser")).getEmail()+"</a>");%>					
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
			<%Group g = (Group)request.getAttribute("group");%>

			 	<p class="smallHeading"><%out.print(g.getName());%></p>
			 	<p><i>Admin: <%out.print(g.getAdmin().getName()+" "+g.getAdmin().getSurname());%></i></p></br>
				<p><i>Description:</i></p>
				<p><%out.print(g.getDescription());%></p></br>
				<p><i>Messages:</i></p>	
				
				<form action="addMessage" method="post">
					<table class="newMessage">						
							<tr><td valign="top">
								 <input type="hidden" name = "group" value="<% out.print(g.getId());%>">
		 						 <textarea name="text" rows="5" cols="50" placeholder="Enter your message"></textarea>
							</td></tr>
							<tr><td>
								 <input type="submit" value="Add message">   
							</td></tr>									
					</table>
				</form>	
				<br/>
				<% ArrayList<Message> messages = (ArrayList<Message>)request.getAttribute("messages"); %>
				<table class="messages">
									<% 	
					if (messages.size()==0) {
						out.print("<h2>No messages yet :'( </h2>\n");
					}
					else {
						for (Message m: messages) {
							out.print("<tr><td><p><b>"+m.getUser().getName()+" "+m.getUser().getSurname()+"</b></p>"+
									"\n<p>"+m.getText()+"</p><p><i>"+m.getDate()+ "</i></p></td>\n"
									+"<td><br/><br/><p><form class=\"mes_form\" action=\"deleteMessage\" method=\"post\">\n<input type=\"hidden\" name = \"message\" value=\""+
									m.getId()+"\"><input type=\"hidden\" name = \"group\" value=\""+
											g.getId()+"\"><input type=\"submit\" value=\"Delete\" id="+g.getId()
									+ "></form>\n<form class=\"mes_form\" action=\"editGroup\" method=\"post\"><input type=\"hidden\" name = \"group\" value=\""+
									g.getId()+"\"><input type=\"submit\" value=\"Edit\" id="+g.getId()
									+ "></form></p></td></tr>\n");
							}
					}
				%>
				</table>
	
			</div><!-- end .main -->
	
		</div><!-- end .body -->
		
		
		<footer>
			<p id="text"> .</p>
		</footer> 
		
	</div><!-- end .container -->
	
</body>
</html>