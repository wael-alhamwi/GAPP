<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Add program</title>
</head>
<body>
<h1>Program add page</h1>
   <div class="container" style="width: 40%;">

      <form class="form-signin" method="post" action="add.html">
        <h2 class="form-signin-heading">Add program</h2>
        <label for="inputPTitle" class="sr-only">program title</label>
        <input type="text" id="inputPTitle" name="title" class="form-control" placeholder="Program title">
        <label for="inputPDesc" class="sr-only">program description</label>
        <input type="text" id="inputPDesc" name="description" class="form-control" placeholder="Program description">
		<input type="hidden" id="inputPOwner" name="programOwner" class="form-control" value="${departmentID}">
        <button class="btn btn-lg btn-success btn-block" type="submit">Add</button>
      </form>
	<a href="../department/details.html?id=${departmentID}"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
    </div>
</body>
</html>
