<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Add requirements</title>
</head>
<body>
<h1>Requirements add page</h1>
   <div class="container" style="width: 40%;">

      <form class="form-signin" method="post" action="add.html">
        <h2 class="form-signin-heading">Add requirements</h2>
        <label for="inputRName" class="sr-only">requirement name</label>
        <input type="text" id="inputRName" name="nameOfField" class="form-control" placeholder="Requirement name">
        <label for="inputRType" class="sr-only">Requirement type</label>
        <input type="text" id="inputRType" name="typeOfField" class="form-control" placeholder="Requirement type">
        <label for="Required" class="sr-only">Required</label>
        <input type="text" id="Required" name="isRequired" class="form-control" placeholder="Required or Not"/>
		<input type="hidden" id="inputROwner" name="additionalReqOwner" class="form-control" value="${depID}">
        <button class="btn btn-lg btn-success btn-block" type="submit">Add</button>
      </form>
	<a href="../department/details.html?id=${depID}"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
    </div>
</body>
</html>
