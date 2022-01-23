<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show students Details</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
</head>
<body>

<header>
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #40826d">
<div>
 <a href="" class="navbar-brand"> Student Management app</a></div>
 <ul class="navbar-nav">
    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Student Details</a></li>
	
 </ul>
 </nav>
</header>
<br>

<div class="row">
                

                <div class="container">
                    <h3 class="text-center">List of Students</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-primary">Add
     New Student</a>
     					<a href="<%=request.getContextPath()%>/selectUserById" class="btn btn-primary">Select user by Id</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Date of Birth</th>
                                <th>Date of joining</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach var="stud" items="${listStudent}">
                                <tr>
                                   <td><c:out value="${stud.studentno}" /></td>
                                    <td><c:out value="${stud.studentname}" /></td>
                                    <td> <c:out value="${stud.dateofbirth}" /></td>                                 
                                    <td><c:out value="${stud.dateofJoin}" /></td>
                                 <td><a href="edit?id=<c:out value='${stud.studentno}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${stud.studentno}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                           
                        </tbody>

                    </table>
                </div>
            </div>


</body>
</html>