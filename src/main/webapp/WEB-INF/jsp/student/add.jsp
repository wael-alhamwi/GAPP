<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<title>Create application</title>

<script type="text/javascript">
function initializeForm() {
	var departmentID = document.getElementById("depDocId").value;
	var programID = document.getElementById("ProgsList").value;
	document.getElementById("inputAdepartment").value = departmentID;
	document.getElementById("inputAprogram").value = programID;
	document.getElementById("inputAstatus").value = "Submitted";
}
</script>

<script type="text/javascript">
function save() {
	document.getElementById("inputAstatus").value = "Not Submitted";
	document.getElementById("submit").click();
}
</script>

<script type="text/javascript">
$(function(){
	$('#depDocId').change(function(){
		$.ajax('update.html?depID='+$('#depDocId').val(), {
    		success: function(departmentProgs){ 
        		$("#progsListDiv").html(departmentProgs);
    		}
		});
	});
});
</script>



</head>
<body>
	<h3>Welcome ${Student.stdUser.firstName} please create new application</h3>
	<div class="container" style="width: 40%;">

<h3 class="form-signin-heading">Select department</h3>
<select id="depDocId" class="form-control">
	<option value="null" selected>Select option</option>
	<c:forEach items = "${departments}" var ="department">
		<option value="${department.id}">${department.name}</option>
	</c:forEach>
</select>

<div id="progsListDiv"></div>
		<form class="form-signin" method="POST">
			<h3 class="form-signin-heading">Create application</h3>
			<label for="inputAterm" class="sr-only">term</label>
			<input type="text" id="inputAterm" name="term" class="form-control" placeholder="Term" />
			<input type="hidden" id="inputAprogram" name="progAppOwner" class="form-control"/>
			<input type="hidden" id="inputAdepartment" name="deptAppOwner" class="form-control"/>
			<input type="hidden" id="inputAstudent" name="stdAppOwner" class="form-control" value="${Student.id}"/>
			<input type="hidden" id="inputAstatus" name="status" class="form-control"/>
			<button class="btn btn-lg btn-success btn-block" id="submit" name="submit" type="submit">Submit</button>
		</form>
		<button class="btn btn-lg btn-success btn-block" id="save" onclick="save()">Save</button>
		<a href="../user/student.html?id=${Student.stdUser.id}"><button class="btn btn-lg btn-primary btn-block">Back</button></a>
</div>
</body>
</html>
