<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Student Details</title>
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
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Student Details</h3>
                    <hr>
                    <div class="container text-left">

                       
				<c:if test="${student != null}">
					<form action="selectUserById" method="post">
				</c:if>
				
				<fieldset class="form-group">
					<label>Enter Student ID</label> 
					<input type="text" class="form-control" name="studid" required="required" value="1">
						
				</fieldset>
     					<button type="submit" class="btn btn-success">Search By Id</button>
     					
     					
     					
				</form>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                
                                <th>Name</th>
                                <th>Date of Birth</th>
                                <th>Date of joining</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach var="stud" items="${select_user_by_id}">
                                <tr>
                                    <td><c:out value="${stud.studentname}" /></td>
                                    <td> <c:out value="${stud.dateofbirth}" /></td>                                 
                                    <td><c:out value="${stud.dateofJoin}" /></td>
                                </tr>
                          <!--  -->  </c:forEach>
                           
                        </tbody>

                    </table>
                </div>
            </div>


</body>
</html>