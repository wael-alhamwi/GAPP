<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>User Details</title>
</head>
<body>
<h2>${user.firstName}'s account details</h2>

<div class="container">
  <h2>User details</h2>                                               
  <table class="table">
    <thead>
      <tr><th>ID</th><th>Username</th><th>First name</th><th>Last name</th><th>Role</th></tr>
    </thead>
    <tbody>
<tr class="success">
  <td>${user.id}</td>
 <td>${user.username}</td>
 <td>${user.firstName}</td>
 <td>${user.lastName}</td>
 <td>${user.role}</td>
</tr>    
</tbody>
</table>
<a href="list.html"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
</div>

</body>
</html>