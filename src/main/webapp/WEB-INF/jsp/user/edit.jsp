<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Edit user</title>
</head>
<body>
<h1>Edit user page</h1>
   <div class="container" style="width: 40%;">

      <form:form class="form-signin" modelAttribute="user">
        <h2 class="form-signin-heading">Edit info</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <form:input type="email" id="inputEmail" path="username" class="form-control"/>
        <label for="inputFname" class="sr-only">First name</label>
        <form:input type="text" id="inputFname" path="firstName" class="form-control"/>
        <label for="inputLname" class="sr-only">Last name</label>
        <form:input type="text" id="inputLname" path="lastName" class="form-control"/>
        <label for="inputRole" class="sr-only">Role</label>
        <form:input type="text" id="inputRole" path="role" class="form-control"/>
        <label for="inputPassword" class="sr-only">Password</label>
        <form:input type="text" id="inputPassword" path="password" class="form-control" />
        <button class="btn btn-lg btn-success btn-block" name="save" type="submit">Save</button>
      </form:form>
	<a href="list.html"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
    </div>
</body>
</html>
