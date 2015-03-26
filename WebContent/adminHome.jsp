<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setDateHeader("Expires", 0); 
response.setHeader("Pragma", "no-cache");
%>
</head>
<body>
Welcome <s:property value="%{#session['user_name']}"></s:property>
<p align="right"><a href="<s:url action="logout"/>">Logout</a></p>

<a href="<s:url action="loadAddUserPage"/>">Add User</a>
<br>
<a href="<s:url action="loadAddCoursePage"/>">Add Course</a>
<br>
<a href="<s:url action="loadAssignGradesPage"/>">Assign Grades</a>
<br>
<a href="<s:url action="loadAddNewsPage"/>">Add News</a>
</body>
</html>