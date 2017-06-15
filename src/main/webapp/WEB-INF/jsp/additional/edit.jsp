<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Edit requirements</title>
</head>
<body>
<h1>Requirements edit page</h1>
   <div class="container" style="width: 40%;">

      <form:form class="form-signin" modelAttribute="requirement">
        <h2 class="form-signin-heading">Edit requirements</h2>
        <label for="inputRName" class="sr-only">requirement name</label>
        <form:input type="text" id="inputRName" path="nameOfField" class="form-control"/>
        <label for="inputRType" class="sr-only">Requirement type</label>
        <form:input type="text" id="inputRType" path="typeOfField" class="form-control"/>
        <label for="Required" class="sr-only">Required</label>
        <form:input type="text" id="Required" path="isRequired" class="form-control" placeholder="Required or Not"/>
 		<form:input type="hidden" id="inputROwner" path="additionalReqOwner" class="form-control"/>
        <button class="btn btn-lg btn-success btn-block" type="submit">Save</button>
      </form:form>
	<a href="../department/details.html?id=${DepID}"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
    </div>
</body>
</html>
