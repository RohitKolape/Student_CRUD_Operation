<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Information</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #40826d">
			<div>
				<a href="" class="navbar-brand"> Student Management app</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Student Details</a></li>

			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="edit" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
                                    Edit User
                                </c:if>
						<c:if test="${student == null}">
                                    Add New User
                                </c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="id" value="<c:out value='${student.studentno}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Enter Name</label> <input type="text"
						value="<c:out value='${student.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Select Birth date</label> <input type="date"
						value="<c:out value='${student.dateofbirth}' />" class="form-control"
						name="dob">
				</fieldset>

				<fieldset class="form-group">
					<label>Select year of join</label> <input type="date"
						value="<c:out value='${student.dateofJoin}' />" class="form-control"
						name="doj">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>