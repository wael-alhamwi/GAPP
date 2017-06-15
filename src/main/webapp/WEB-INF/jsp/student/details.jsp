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
<title>Application Details</title>
</head>
<body>

<div class="container">
<h2>Application ID: ${app.id}</h2>

  <h2>Application detail</h2>                                               
  <table class="table">
    <thead>
      <tr><th>Date submitted</th><th>Application Department</th><th>Application program</th><th>Term</th><th>Status</th><th>Operations</th></tr>
    </thead>
    <tbody>
<tr class="success">
  <td>${app.submitDate}</td>
  <td>${app.deptAppOwner.name}</td>
  <td>${app.progAppOwner.title}</td>
  <td>${app.term}</td>
  <td>${app.status}</td>
  <td>
  <c:if test="${app.status == 'Not Submitted'}">
  <a href="edit.html?id=${app.id}">Edit</a>
  </c:if>
  </td>
</tr>
</tbody>
</table>

<br>

  <h2>Student's personal info</h2>                                               
  <table class="table">
    <thead>
      <tr><th>ID</th><th>First name</th><th>Last name</th><th>Phone</th><th>Gender</th><th>DOB</th><th>Citizenship</th></tr>
    </thead>
    <tbody>
<tr class="success">
	<td>${std.id}</td>
  <td>${std.studentPersonalInfo.firstName}</td>
  <td>${std.studentPersonalInfo.lastName}</td>
  <td>${std.studentPersonalInfo.phoneNumber}</td>
  <td>${std.studentPersonalInfo.gender}</td>
  <td>${std.studentPersonalInfo.dateOfBirth}</td>
  <td>${std.studentPersonalInfo.citizenship}</td>
</tr>
</tbody>
</table>
<br>
  <h2>Student's education</h2>                                               
  <table class="table">
    <thead>
      <tr><th>Degree</th><th>Major</th><th>Period of attendance</th><th>University</th><th>GPA</th><th>TOEFL</th><th>GRE</th><th>Operations</th></tr>
    </thead>
    <tbody>
<c:forEach items="${app.studentEducationInfo}" var="edu">
<tr class="success">
  <td>${edu.degree.degree}</td>
  <td>${edu.degree.major}</td>
  <td>${edu.degree.periodOfAttendence}</td>
  <td>${edu.degree.university}</td>
  <td>${edu.academic.GPA}</td>
  <td>${edu.academic.TOEFL}</td>
  <td>${edu.academic.GRE}</td>
  <td>
  <ol>
  <c:forEach items="${app.files}" var="file">
  <li><a href="download.html?id=${file.id}">${file.fileName}</a><a href="remove.html?id=${file.id}"> Remove</a></li>
  </c:forEach>
  </ol>
  <c:if test="${app.status == 'Not Submitted'}">
  Upload:
  <a href="upload.html?id=${app.id}">Upload</a>
  </c:if>
  </td>
</tr>
</c:forEach>
</tbody>
</table>

<a href="list.html?id=${app.stdAppOwner.stdUser.id}"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
<a href="../home.html"><button class="btn btn-lg btn-danger btn-block">Logout</button></a>
</div>
</body>
</html>