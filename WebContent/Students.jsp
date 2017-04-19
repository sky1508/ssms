<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>City</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentList}" var="student">
			<tr>
				<td><c:out value ="${student.id}"/></td>
				<td><c:out value ="${student.name}"/></td>
				<td><c:out value ="${student.city}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>