<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="overtime()">加班申請表單</button>
<button onclick="leave()">請假申請表單</button>
<form methon="post" action="#" id="form">
	<input type="text" name="text" />
	<br>
	想要給誰簽核 : 
	<c:forEach items="${emps}" var="emp">
		<input type="checkbox" name="selectEmp" value="${emp.empId}">
		${emp.empName} ${emp.employeeInfo.title.titleName}<br>
	</c:forEach>
	
	<input type="submit"/>
</form>
<script>
function overtime() {
	document.getElementById("form").action="overtime";
}
function leave() {
	document.getElementById("form").action="leave";
}
</script>
</body>
</html>