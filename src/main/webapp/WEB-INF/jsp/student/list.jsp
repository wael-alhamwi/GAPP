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
<title>Applications list</title>
</head>
<body>
<div class="container">
  <h2>Applications Table</h2>                                               
  <table class="table">
    <thead>
      <tr><th>Date submitted</th><th>Application Department</th><th>Application program</th><th>Term</th><th>Status</th><th>Operations</th></tr>
    </thead>
    <tbody>
<c:forEach items="${apps}" var="app">
<c:if test="${stdUserID == app.stdAppOwner.stdUser.id}">
<tr class="success">
  <td>${app.submitDate}</td>
  <td>${app.deptAppOwner.name}</td>
  <td>${app.progAppOwner.title}</td>
  <td>${app.term}</td>
  <td>${app.status}</td>
  <td>
  <a href="details.html?id=${app.id}">Details</a>
  <c:if test="${app.status == 'Not Submitted'}">
  <a href="edit.html?id=${app.id}">Edit</a>
  </c:if>
  </td>
</tr>
</c:if>
</c:forEach>
</tbody>
</table>
<a href="../user/student.html?id=${stdUserID}"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
</div>
</body>
</html>