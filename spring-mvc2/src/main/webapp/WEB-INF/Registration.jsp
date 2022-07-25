<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
.container {
	border: 2px solid red;
	margin: 20px;
	text-align: center;
}
</style>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="box">

			<form action="readRegistrationPage">
				<pre>
		*SportName: <input type="text" name="sportName" required> 
		<p style="color: red"> ${errorSportName} </p>
		
		*NoOfPlayers: <input type="number" name="noOfPlayers" required>
		<p style="color: red"> ${errorNoOfPlayers} </p>
		
		*CaptainName: <input type="text" name="captainName" required>
		<p style="color: red"> ${errorCaptainName} </p>
		
		*Coach: <input type="text" name="sportCoach" required>
		<p style="color: red"> ${errorSportCoach} </p>
		
		*Date: <input type="text" name="sheduledDate" required>
		<p style="color: red"> ${errorSheduledDate} </p>
		
		<input type="submit" name="Submit" onclick="getAlertMsg()">
		</pre>

			</form>

		</div>

		<!---------------	 Search operation is started 	-------------->

		<form action="searchBySportName">
			SportName: <input type="text" name="sportName"> <input
				type="submit" name="search">


			<p style="color: red">${searchSportName}</p>

		</form>

		<!---------------	 Delete operation is started 	-------------->

		<form action="deleteSportBeanBySportName">
			SportName: <input type="text" name="sportName"> <input
				type="submit" name="delete">
			<p style="color: green">${success}</p>
			<p style="color: red">${unsuccess}</p>

		</form>

		<br> <br>
		<ol>
			<li>${SportName}</li>
			<li>${CaptainName}</li>
			<li>${SportCoach}</li>
			<li>${SheduledDate}</li>
			<li>${NoOfPlayers}</li>
		</ol>
		<a href="getAllSportData">getAllSportData</a>
		<div>
			<table class="table">
				<thead class="" style="border: medium;">
					<tr>
						<th>SportName</th>
						<th>NoOfPlayers</th>
						<th>CaptainName</th>
						<th>Coach</th>
						<th>Date</th>
					</tr>

				</thead>

				<c:forEach items="${listController}" var="table">

					<tr>
						<td>${table.sportName}</td>
						<td>${table.noOfPlayers}</td>
						<td>${table.captainName}</td>
						<td>${table.sportCoach}</td>
						<td>${table.sheduledDate}</td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>

	<script>
		function getAlertMsg() {
			alert("Submited sucussfully")

		}
	</script>
</body>
</html>