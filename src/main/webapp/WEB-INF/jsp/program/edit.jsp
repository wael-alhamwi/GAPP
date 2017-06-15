<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Edit program</title>
</head>
<body>
<h1>Program edit page</h1>
   <div class="container" style="width: 40%;">

      <form:form class="form-signin" modelAttribute="program">
        <h2 class="form-signin-heading">Edit program</h2>
        <label for="inputPTitle" class="sr-only">program title</label>
        <form:input type="text" id="inputPTitle" path="title" class="form-control"/>
        <label for="inputPDesc" class="sr-only">program description</label>
        <form:input type="text" id="inputPDesc" path="description" class="form-control"/>
        <button class="btn btn-lg btn-success btn-block" type="submit">Save</button>
      </form:form>
	<a href="../department/details.html?id=${DepID}"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
    </div>
</body>
</html>
