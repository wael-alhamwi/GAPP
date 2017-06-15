<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Upload form</title>
</head>
<body>
<h1>Upload file page</h1>
<div class="container" style="width: 40%;" align="center">
<form action="upload.html" method="post" enctype="multipart/form-data">
<h2 class="form-signin-heading">Upload file</h2>
<input style="width: 100%;" type="file" name="file"/> <br />
<input type="submit" class="btn btn-success btn-block" name="upload" value="Upload" />
</form>
</div>
</body>
</html>