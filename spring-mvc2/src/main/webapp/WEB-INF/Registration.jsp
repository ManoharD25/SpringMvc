<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style type="text/css">
#first {
	width: 100%;
	height: 100%;
	background-color: gray;
}

#first #second {
	margin-top: 0px;
	width: 350px;
	height: 50%;
	background: green;
	text-align: left;
	width: 350px;
}

table, th, td {
	border: 1px solid;
}

table {
	width: 100%;
}
</style>
<!------------------------------------ Links are present here --------------------------------------->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<!------------------------------------- Body Started here --------------------------------------------------->
<body>
	<div id="first">
		<nav class="navbar navbar-expand-lg navbar-light"
			style="background-color: peru;">
			<div class="container-fluid">

				<h2 style="text-align: center;"
					onclick="/getRegistrationPage.sports">Homepage</h2>
				&nbsp;
				<div class="flex">
					<button type="button" name="newMail"
						style="background-color: blue;">
						<a href="getMailPage.mail">New Mail</a>
					</button>
				</div>
				<div class="d-flex">
					<button type="button" data-toggle="modal" data-target="#addModal"
						class="btn btn-success">Add Sport</button>
				</div>
			</div>
		</nav>
		<br>
		<button style="border-radius: 22px; background-color: rosybrown">
			<a href="getAllSportData.sports" onclick="getAllTable()"
				style="color: red;"> getAllSportData </a>
		</button>
		<br>
		<!---------------	 Search operation is start here 	-------------->

		<form action="searchBySportName.sports" method="post">
			<input type="text" name="sportName" placeholder="Enter Name">
			<button type="submit" onclick="searchAlertMsg()"
				class="btn btn-primary">
				<i class="fa fa-search"></i>
			</button>
			<h2 style="text-align: center;">${searched}${notsearched}</h2>
			<p style="color: red">${searchSportName}</p>

		</form>

		<!---------------	 Delete operation is started 	-------------->

		<form action="deleteSportBeanBySportName.sports" method="post">
			<input type="text" name="sportName" placeholder="Enter Name">
			<button type="submit" class="btn btn-danger">Delete</button>
			<p style="color: green">${delete}</p>
			<h2 style="text-align: center;">${delete}${Notdelete}</h2>
			<p style="color: red">${Notdelete}</p>

		</form>

		<form action="updateSportBeanBySportName.sports">

			<button type="button" data-toggle="modal" data-target="#updateModal"
				class="btn btn-warning">Edit</button>
			<p style="color: green">${updated}</p>
			<p style="color: red">${notupdated}</p>

		</form>
		<h2 style="text-align: center;">${updated}${notupdated}</h2>
		<table id="getAllTable" class="table table-bordered table-primary">
			<thead style="background-color: rgb(106, 141, 106)">
				<tr>
					<th scope="col">SportName</th>
					<th scope="col">NoOfPlayers</th>
					<th scope="col">CaptainName</th>
					<th scope="col">Coach</th>
					<th scope="col">Date</th>
				</tr>

			</thead>
			<tbody style="background-color: #15ebb2">
				<tr>
					<td>${sportName}</td>
					<td>${noOfPlayers}</td>
					<td>${captainName}</td>
					<td>${sportCoach}</td>
					<td>${sheduledDate}</td>
				</tr>
				<c:forEach items="${listController}" var="table">

					<tr>
						<td>${table.sportName}</td>
						<td>${table.noOfPlayers}</td>
						<td>${table.captainName}</td>
						<td>${table.sportCoach}</td>
						<td>${table.sheduledDate}</td>
					</tr>


				</c:forEach>
			</tbody>
		</table>

		<!------------------------------------ Modal/pop-up page for adding  start here --------------------------------------->

		<!-- Modal -->
		<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="background-color: darkslategray">
					<div class="modal-header"
						style="background-color: rgb(228, 72, 16)">
						<h5 class="modal-title" id="exampleModalLabel">New Sport Data</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="readRegistrationPage.sports" method="post">
							<pre>
		*<input type="text" name="sportName" placeholder="SportName" required>
		<p style="color: red"> ${errorSportName} </p>
		
		*<input type="number" name="noOfPlayers" placeholder="NoOfPlayers"
									required>
		<p style="color: red"> ${errorNoOfPlayers} </p>
		
		*<input type="text" name="captainName" placeholder="CaptainName"
									required>
		<p style="color: red"> ${errorCaptainName} </p>
		
		*<input type="text" name="sportCoach" placeholder="Coach Name"
									required>
		<p style="color: red"> ${errorSportCoach} </p>
		
		*<input type="text" name="sheduledDate" placeholder="SheduledDate"
									required>
		<p style="color: red"> ${errorSheduledDate} </p>
		
		<input type="submit" name="Submit" onclick="getAlertMsg()">
		</pre>

						</form>
					</div>

				</div>
			</div>
		</div>

	</div>


	<!------------------------------------ Modal/pop-up page for update  start here --------------------------------------->
	<!-- Modal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content" style="background-color: cornflowerblue;">
				<div class="modal-header" style="background-color: lightseagreen">
					<h5 class="modal-title" id="exampleModalLabel">Update Data</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="updateSportBeanBySportName.sports" method="post">
						<pre>
						
		*<input type="text" name="sportName" placeholder="SportName"
								value="${sportName}" required>
		<p style="color: red"> ${errorSportName} </p>
		
		*<input type="number" name="noOfPlayers" placeholder="NoOfPlayers"
								value="${noOfPlayers}" required>
		<p style="color: red"> ${errorNoOfPlayers} </p>
		
		*<input type="text" name="captainName" placeholder="CaptainName"
								value="${captainName}" required>
		<p style="color: red"> ${errorCaptainName} </p>
		
		*<input type="text" name="sportCoach" placeholder="Coach Name"
								value="${sportCoach}" required>
		<p style="color: red"> ${errorSportCoach} </p>
		
		*<input type="text" name="sheduledDate" placeholder="SheduledDate"
								value="${sheduledDate}" required>
		<p style="color: red"> ${errorSheduledDate} </p>
		
		<input type="submit" name="Submit" value="Update"
								onclick="updateAlertMsg()">
		</pre>
					</form>

				</div>

			</div>
		</div>
	</div>
	<!------------------------------------ All the script tags are find here --------------------------------------->

	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

	<!------------------------------------ These are provide Bootstarp configurations to the page --------------------------------------->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
		crossorigin="anonymous"></script>

	<!------------------------------------This provides js files in the application  --------------------------------------->

	<script src="js/HomePage.js"></script>

</body>
</html>