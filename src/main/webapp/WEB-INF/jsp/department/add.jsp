<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Add department</title>
</head>
<body>
<h1>Department add page</h1>
   <div class="container" style="width: 40%;">

      <form:form class="form-signin" modelAttribute="department">
        <h2 class="form-signin-heading">Add department</h2>
        <label for="inputDname" class="sr-only">Department name</label>
        <form:input type="text" id="inputDname" path="name" class="form-control" placeholder="Department name"/>
        <button class="btn btn-lg btn-success btn-block" name="add" type="submit">Add</button>
      </form:form>
	<a href="./list.html"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
    </div>
</body>
</html>
