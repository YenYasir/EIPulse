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
<th>項次</th>
<th>申請人</th>
<th>表單類型</th>
</tr>
<c:forEach items="${reviews}" var="review" varStatus="s">
<tr>
<td><a href="formCheck?formId=${review.formRecord.formId}">${s.count}</a></td>
<td>${review.formRecord.empId}</td>
<td>${review.formRecord.formType.typeName}</td>
</tr>
</c:forEach>
</table>
</body>
</html>