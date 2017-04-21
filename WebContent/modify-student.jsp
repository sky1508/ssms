<%@ page import="com.ssms.dao.StudentDAO"%>
<%@ page import="com.ssms.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	Student student = StudentDAO.getStudentById(Integer.parseInt(request.getParameter("id")));
	request.setAttribute("student", student);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Student</title>
</head>
<body>
	<form action="ModifyStudent" method="get">
		<input type="hidden" name="id" value='<c:out value="${student.id}"></c:out>'/>
		Name: <input type="text" name="name" value='<c:out value="${student.name}"></c:out>'/>
		<br>
		City: <input type="text" name="city" value='<c:out value="${student.city}"></c:out>'/>
		<br>
		<input type="submit" value="Add"/>
	</form>
</body>
</body>
</html>