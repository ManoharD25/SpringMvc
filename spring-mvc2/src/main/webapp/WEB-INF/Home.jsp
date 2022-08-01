<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<form action="sendJavaMailController.mail" method="post">
	
	To: <input  type="text" name="mailId"> <br>
	Subject: <input type="text" name="subject"> <br>
	Message: <input type="text" name="message">
	<button type="submit" name="send">Send</button>
	</form>
</body>
</html>