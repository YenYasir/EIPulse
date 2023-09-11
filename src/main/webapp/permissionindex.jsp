<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<style>
.tdcss:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<button onclick="select()">查詢員工權限</button>
	<button onclick="update()">查詢員工權限</button>
	<button onclick="insert()">新增權限</button>
	<c:if test="${jspOpen == 1 }">
		<table id="datatable">
			<thead>
				<tr>
					<th>員工編號</th>
					<th>員工姓名</th>
					<th>部門</th>
					<th>職位</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${emps}" var="emp">
					<tr>
						<td class="tdcss" onclick="ck()">${emp.empId}</td>
						<td>${emp.empName}</td>
						<td>${emp.employeeInfo.dept.deptName}</td>
						<td>${emp.employeeInfo.title.titleName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<script>
		let table = $('#datatable').DataTable();
		function select() {
			location.href = "PermissionEmp";
		}
		function update() {
			alert('還沒有這個功能');
		}
		function insert() {
			alert('還沒有這個功能');
		}
		function ck() {
			
		}

		function up() {
			var jsonData = dataTable.rows().data().toArray();
			$.ajax({
				url : '網址',
				method : 'POST',
				data : JSON.stringify(jsonData),
				contentType : 'application/json'
			});
		}
	</script>
</body>
</html>