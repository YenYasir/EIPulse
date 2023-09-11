<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>

<style>
.div1 {
	width: 400px;
	border: 2px double black;
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<div class="div1">
	
		<div>
			<h2>新增員工資料</h2>
			<form method="post" action="InsertEmp" enctype="multipart/form-data">
				輸入身分證字號：<input type="text" id="id" name="idNumber" />
				<p>
					輸入員工姓名：<input type="text" id="name" name="empName" />
				<p>
					選擇員工性別：<select name="Gender">
						<option value="M">男</option>
						<option value="F">女</option>
					</select>
				<p>
					輸入員工生日：<input type="date" id="birth" name="birth" />
				<p>
					上傳大頭照：<input type="file" name="photo" />
				<p>

		</div>

		<div style="border-top: 4px double black">
			<h2>聯絡資料</h2>
			手機：<input type="text" id="phone" name="phone" />
			<p>
				電話：<input type="text" id="tel" name="tel" />
			<p>
				地址：<input type="text" id="address" name="address" />
			<p>
				信箱：<input type="text" id="email" name="email" />
			<p>
		</div>

		<div style="border-top: 4px double black">
			<h2>職位</h2>
			<label>部門：</label> <select name="detpid">
				<c:forEach items="${sessionScope.dept}" var="dept" varStatus="s">
					<option value="${dept.deptId}">${dept.deptName}</option>
				</c:forEach>
			</select><br> <label>職位：</label> <select name="titleid">
				<c:forEach items="${sessionScope.title}" var="title" varStatus="s">
					<option value="${title.titleId}">${title.titleName}</option>
				</c:forEach>
			</select>
			<p>
		</div>

		<div style="border-top: 4px double black">
			<h2>緊急聯絡人</h2>
			緊急聯絡人姓名：<input type="text" name="emergencyName" />
			<p>
				緊急聯絡人電話：<input type="text" name="emergencyPhone" />
			<p>
				聯絡人關係：<input type="text" name="emergencyRelationship" />
			<p>
				<input type="submit" value="新增" />
		</div>

		</form>
	</div>
	
</body>
</html>