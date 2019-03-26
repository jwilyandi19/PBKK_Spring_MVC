<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PBKK Calculator</title>
</head>
<body>
	<h1>PBKK Simple Calculator</h1>
	
	<form:form method="POST" action="/spring-mvc/addcalculator" modelAttribute="calculator">
		<table>
			<tr>
				<td><form:label for="num1" path="num1">First Number:</form:label></td>
				<td><form:input path="num1"/></td>
			</tr>
			<tr>
				<td><form:label for="num2" path="num2">Second Number:</form:label></td>
				<td><form:input path="num2"/></td>
			</tr>
			<tr>
				<td><form:label path="operation">Operation:</form:label></td>
				<td>
					<form:select path="operation">
						<form:options items = "${operationList}" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>