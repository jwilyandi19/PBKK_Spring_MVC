<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored = "false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PBKK Calculator</title>
</head>
<body>
	<h1>PBKK Simple Calculator Result</h1>
	<table>
		<tr>
			<td>First Number:</td>
			<td>${num1}</td>
		</tr>
		<tr>
			<td>Second Number:</td>
			<td>${num2}</td>
		</tr>
		<tr>
			<td>Operation:</td>
			<td>${operation}</td>
		</tr>
		<tr>
			<td>Result:</td>
			<td>${resultcalc}</td>
	</table>

</body>
</html>