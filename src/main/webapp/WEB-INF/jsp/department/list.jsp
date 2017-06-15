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
<title>Departments list</title>
</head>
<body>
<div class="container">
  <h2>Departments Table</h2>                                               
  <table class="table">
    <thead>
      <tr><th>Name</th><th>No. Programs offered</th><th>Operations</th></tr>
    </thead>
    <tbody>
<c:forEach items="${depts}" var="dept">
<tr class="success">
  <td>${dept.name}</td>
  <td>${dept.programs.size()}</td>
  <td>
  <a href="details.html?id=${dept.id}">Details</a>
  <a href="../program/add.html?id=${dept.id}">Add Program</a>
  <a href="../additional/add.html?id=${dept.id}">Add requirements</a>
  <a href="edit.html?id=${dept.id}">Edit</a>
  <a href="remove.html?id=${dept.id}">Remove</a>
  </td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="add.html"><button class="btn btn-lg btn-success btn-block">Add Department</button></a>
<a href="../user/admin.html"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
</div>
</body>
</html>