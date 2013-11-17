<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Google Chew::Login</title>
</head>
<body>
		
	<div class="top">			
		<table class="top-nav">
			<tr>
				<td id="text">Goggle Chew</td>
				<td><table id="login"><tr>
				
				</tr></table></td>					
			</tr>
		</table>
	</div>
	
	<div class="container">
		<div class="header">
			<h1>Login </h1>
		</div>
		
		
		<div class="body">
			<form action="logged" method="post">
				<table>					
						<tr>
							<td valign="top"><input  type="text" name="email" maxlength="50" size="30" 
							placeholder="email"></td>
						</tr>
						<tr>
	 						<td valign="top"><input  type="password" name="password" maxlength="50" size="30"
	 						placeholder="password"></td>
						</tr>
						
						<tr><td>
							 <input type="submit" value="Login">   
						</td></tr>					
				</table>
			</form>
	
		</div><!-- end .body -->
		
		
		<div class="footer">
			<p id="text">footer</p>
		</div><!-- end .footer -->
		
	</div><!-- end .container -->
	
</body>
</html>