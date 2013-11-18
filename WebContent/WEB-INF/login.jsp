<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Google Chew::Login</title>
</head>
<body>
		
	<div class="top">			
		<center><div class="top-nav">
			<div class="logo">Google Chew</div>
						
		</div></center>
	</div>
	
	<div class="container">
		<div class="header">
			<h1>Login </h1>
		</div>
		
		
		<div class="body">
			<center><form action="logged" method="post">
				<table id="login_table">					
						<tr>
							<td valign="top"><input  type="text" name="email" maxlength="50" size="30" 
							placeholder="email"></td>
						</tr>
						<tr>
	 						<td valign="top"><input  type="password" name="password" maxlength="50" size="30"
	 						placeholder="password"></td>
						</tr>
						
						<tr><td>
							<center> <input type="submit" value="Sign In">  </center> 
						</td></tr>					
				</table>
			</form></center>
			<center>
				<p>Don't have an account?</p>
				<!--  <form method = POST action = "./signUp">
					<input type="submit"  value="Sign Up"/>
				</form>-->
				<button><a href="/Network/signUp.html">Sign Up</a></button>
			</center>
	
		</div><!-- end .body -->
		
		
		<div class="footer">
			<p id="text">footer</p>
		</div><!-- end .footer -->
		
	</div><!-- end .container -->
	
</body>
</html>