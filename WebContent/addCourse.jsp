<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma", "no-cache");
%>
</head>
<body>
<s:form action="addCourse" method="post" enctype="multipart/form-data">
Course Name: <input type="text" name="courseName">
<br>
Course ID: <input type="text" name="courseId">
<br>
<s:select  name="faculty" label="Faculty" list="facultyList"/>
<br>
Semester: <input type="text" name="semester">
<br>
<s:submit key="Save"/>
</s:form>
</body>
</html>