<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="db.*" import="java.util.*" import="mod.*"  import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/main.css">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Google Chew::Edit User</title>
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
			<h1>Edit User </h1>
		</div>
		
		
		<div class="body">
			<table>
				<form action="saveUser" method="post">
					<tr>
						<td valign="top"><label for="name">Name</label></td>
						<td valign="top"><input  type="text" name="name" maxlength="50" size="30"></td>
					</tr>
					<tr>
						<td valign="top"><label for="surname">Surname</label></td>
 						<td valign="top"><input  type="text" name="surname" maxlength="50" size="30"></td>
					</tr>
					<tr>
						<td valign="top"><label for="birthday">Birthday</label></td>
						<td valign="top"><input  type="text" name="birthday" maxlength="50" size="30"></td>
					</tr>
					<tr></tr>
					<tr>
						<td valign="top"><label for="country">Country</label></td>
						<td valign="top"><input  type="text" name="country" maxlength="50" size="30"></td>
					</tr>
					<tr>
						<td valign="top"><label for="city">City</label></td>
 						<td valign="top"><input  type="text" name="city" maxlength="50" size="30"></td>
					</tr>
					<tr>
						<td valign="top"><label for="profession">Profession</label></td>
						<td valign="top"><input  type="text" name="profession" maxlength="50" size="30"></td>
					</tr>
					
					<tr>
						<td valign="top"><label for="interests">Interests</label></td>
						<td valign="top"><textarea name="interests" rows="4" cols="50"></textarea></td>
						
					</tr>
					
					
					<tr><td>
						 <input type="submit" value="Save">   
					</td></tr>
				</form>
				
			</table>
		</div><!-- end .body -->
		
		
		<div class="footer">
			<p id="text">footer</p>
		</div><!-- end .footer -->
		
	</div><!-- end .container -->	
</body>
</html>