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
<title>Department Details</title>
</head>
<body>

<h2>Department name: ${department.name}</h2>

<div class="container">
  <h2>Programs Table</h2>                                               
  <table class="table">
    <thead>
      <tr><th>ID</th><th>Title</th><th>Description</th><th>Operations</th></tr>
    </thead>
    <tbody>
<c:forEach items="${deptProgs}" var="prog">
<tr class="primary">
  <td>${prog.id}</td>
  <td>${prog.title}</td>
  <td>${prog.description}</td>
  <td>
  <a href="../program/edit.html?id=${prog.id}&depID=${dept.id}">Edit</a>
  <a href="../program/remove.html?id=${prog.id}&depID=${dept.id}">Remove</a>
  </td>
</tr>
</c:forEach>
</tbody>
</table>

<br>
 <h2>Additional Requirements Table</h2>                                               
  <table class="table">
    <thead>
      <tr><th>ID</th><th>Required</th><th>Name</th><th>Type</th><th>Operations</th></tr>
    </thead>
    <tbody>
<c:forEach items="${deptAdReqs}" var="req">
<tr class="primary">
  <td>${req.id}</td>
  <td>${req.isRequired}</td>
  <td>${req.nameOfField}</td>
  <td>${req.typeOfField}</td>
  <td>
  <a href="../additional/edit.html?id=${req.id}&depID=${dept.id}">Edit</a>
  <a href="../additional/remove.html?id=${req.id}&depID=${dept.id}">Remove</a>
  </td>
</tr>
</c:forEach>
</tbody>
</table>

<a href="list.html"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
<a href="../home.html"><button class="btn btn-lg btn-danger btn-block">Logout</button></a>
</div>
</body>
</html>