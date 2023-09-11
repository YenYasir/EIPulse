<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.tdcss:hover {
	cursor: pointer;
}
</style>
</head>
<body>

	<button onclick="select()">查詢員工權限</button>
	<button onclick="insert()">新增權限</button>
	<br>${emp.empName}
	<c:choose>
                <c:when test="${result != 1}">
	<form method="post" action="updateperemp?id=${emp.empId}">
		<c:forEach items="${permission}" var="per" varStatus="s">
			<label>${per.grade}</label>
			<c:set var="num" value="${s.count}" />
			<c:forEach items="${emp.permissions}" var="empper" varStatus="c">
				<c:if test="${empper.permissionId == per.permissionId }">
					<c:set var="lv" value="${empper.permissionId}" />
				</c:if>
			</c:forEach>
			<c:choose>
					<c:when test="${lv == per.permissionId }">
						<input type="checkbox" name="per${per.permissionId}" checked>
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="per${per.permissionId}">
					</c:otherwise>
				</c:choose>
		</c:forEach>
		
                    <input type="hidden" name="num" value="${num}"> <br> <input
			type="submit" value="更改" />
	</form>
	</c:when>
                <c:otherwise>
                    <button onclick="select()">返回查詢</button><br>
                    ${err}
                </c:otherwise>
            </c:choose>
	
	<script>
		function select() {
			location.href = "permissionEmp";
		}
		function update() {
			alert('還沒有這個功能');
		}
		function insert() {
			alert('還沒有這個功能');
		}
	</script>
</body>
</html>