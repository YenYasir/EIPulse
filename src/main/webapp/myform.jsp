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
<table>
<tr>
<th>項次</th>
<th>表單類型</th>
<th>表單狀態</th>
</tr>
<c:forEach items="${myForms}" var="myForm" varStatus="s">
<tr>
<td><a href="">${s.count}</a></td>
<td>${myForm.formType.typeName}</td>
<td><c:if test="${myForm.endDate==null}">審核中</c:if>
<c:if test="${myForm.endDate!=null}">已審核</c:if></td>
</tr>
</c:forEach>
</table>
</body>
</html>