<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Student page</title>
</head>
<body>
	<h1>Welcome ${student.firstName}</h1>
	<div class="container">
		<h2 class="form-signin-heading">Operations</h2>
		<a href="../student/list.html?id=${student.id}"><button
				class="btn btn-lg btn-primary btn-block">Show applications</button></a>
		<a href="../student/add.html?id=${student.id}"><button
				class="btn btn-lg btn-primary btn-block">Create application</button></a>
		<a href="../home.html"><button
				class="btn btn-lg btn-danger btn-block">Logout</button></a>
	</div>
</body>
</html>
