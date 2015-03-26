<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Grades</title>
</head>
<body>
<s:form action="gradesAction" method="post">
<s:select name="student" list="studentList" label="Student"/>
<s:select  name="course" label="Course" list="courseList"/>
<s:select  name="grade" label="Grade" list="gradeList"/>
<s:submit key="Assign"></s:submit>
</s:form>
</body>
</html>