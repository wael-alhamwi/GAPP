<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Administrator management</title>
</head>
<body>
<h1>Administrator management</h1>
   <div class="container" style="width: 40%;">
        <h2 class="form-signin-heading">Operations</h2>
        <a href="../department/list.html"><button class="btn btn-lg btn-primary btn-block">List departments</button></a>
        <a href="../department/add.html"><button class="btn btn-lg btn-success btn-block">Add department</button></a>
        <a href="../user/list.html"><button class="btn btn-lg btn-primary btn-block">List users</button></a>
        <a href="../user/add.html"><button class="btn btn-lg btn-success btn-block">Add user</button></a>
        <a href="../home.html"><button class="btn btn-lg btn-danger btn-block">Logout</button></a>
    </div>
</body>
</html>
