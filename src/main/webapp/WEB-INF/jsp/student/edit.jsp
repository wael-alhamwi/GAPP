<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<title>Edit application</title>

<script type="text/javascript">
function initializeForm() {
	var departmentID = document.getElementById("DepsList").value;
	var programID = document.getElementById("ProgsList").value;
	document.getElementById("inputAdepartment").value = departmentID;
	document.getElementById("inputAprogram").value = programID;
}
</script>

<script type="text/javascript">
function save() {
	document.getElementById("inputAstatus").value = "Not Submitted";
	document.getElementById("submit").click();
}
</script>

</head>
<body>
	<h3>Welcome ${application.stdAppOwner.firstName} please Edit your application</h3>
	<div class="container" style="width: 40%;">

<h3 class="form-signin-heading">Select department</h3>
<select id="DepsList" class="form-control">
	<option value="${app.deptAppOwner.id}" selected disabled>${app.deptAppOwner.name}</option>
</select>

<select id="ProgsList" class="form-control" onchange="initializeForm()">
	<option value="${app.progAppOwner.id}" selected>${app.progAppOwner.title}</option>
	<c:forEach items="${app.deptAppOwner.programs}" var="prog">	
		<option value="${prog.id}">${prog.title}</option>
	</c:forEach>

</select>
		<form class="form-signin" method="POST">
			<h3 class="form-signin-heading">Edit application</h3>
			<label for="inputAterm" class="sr-only">term</label>
			<input type="text" id="inputAterm" name="term" class="form-control" placeholder="Term" value="${app.term}"/>
			<input type="hidden" id="inputAprogram" name="progAppOwner" class="form-control" value="${app.progAppOwner.id}"/>
			<input type="hidden" id="inputAdepartment" name="deptAppOwner" class="form-control" value="${app.deptAppOwner.id}"/>
			<input type="hidden" id="inputAstudent" name="stdAppOwner" class="form-control" value="${app.stdAppOwner.id}"/>
			<input type="hidden" id="inputAstatus" name="status" class="form-control" value="Submitted"/>
			<input type="hidden" id="inputAppID" name="appID" class="form-control" value="${app.id}"/>
			<button class="btn btn-lg btn-success btn-block" id="submit" name="submit" type="submit">Submit</button>
		</form>
		<button class="btn btn-lg btn-success btn-block" id="save" onclick="save()">Save</button>
		<a href="../student/list.html?id=${app.stdAppOwner.stdUser.id}"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
</div>
</body>
</html>