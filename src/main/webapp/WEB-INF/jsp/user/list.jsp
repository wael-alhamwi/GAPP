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
<title>Users</title>
</head>
<body>

<div class="container" >
  <h2>Users Table</h2>                                               
  <table class="table">
    <thead>
      <tr><th>ID</th><th>Username</th><th>Operation</th></tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
<tr class="success">
  <td>${user.id}</td>
 <td>${user.username}</td>
 <td>
 <a href="details.html?id=${user.id}">Details</a>
 <a href="edit.html?id=${user.id}">Edit</a>
 <a href="remove.html?id=${user.id}">Delete</a>
  </td>
</tr>
</c:forEach> 
</tbody>
</table>
<a href="admin.html"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
<a href="../home.html"><button class="btn btn-lg btn-success btn-block">Sign in page</button></a>
</div>

</body>
</html>