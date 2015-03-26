<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma", "no-cache");
%>
</head>
<body>
<s:form action="addUser" method="post" enctype="multipart/form-data">
Student Name: <input type="text" name="studentName">
<br>
Age: <input type="text" name="age">
<br>
Roll Number: <input type="text" name="rollNo">
<br>
User Name: <input type="text" name="userName">
<br>
Password: <input type="text" name="password">
<s:file name="imagePath" label="Photograph"/>
<s:submit key="Submit"/>
</s:form>
</body>
</html>