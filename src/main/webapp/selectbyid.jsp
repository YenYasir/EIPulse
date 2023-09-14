<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Title</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="CSS/SelectById.css" />
</head>
<body>
	<div class="div1">
		<!-- 利用dogetempID進行update資料然後鎖住EMPID讓用戶無法更改 -->
		<form id="editForm" method="post" action="UpdateEmp?id=${emp.empId}"
			enctype="multipart/form-data">
			<table id="datatable" class="display">
				<thead>
					<tr>
						<th>員工資料</th>
						<th class="photofile"><img
							src="data:image/jpg;base64,${base64Picture}" alt="圖片"
							class="empPhoto"> <input type="file"  name="photo"
							id="inputPhoto" style="display: none;"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td >員工編號:</td>
						<td><input type="text" disabled="disabled"
							value="${emp.empId}" name="id"></td>
					</tr>
					<tr>
						<td>身分證字號:</td>
						<td><input type="text" pattern="^[A-Z][0-9]{9}$"
							placeholder="請輸入身分證字號" title="請輸入有效身分證格式" readonly="readonly"
							value="${emp.idNumber}" name="idNumber" id="idNumber" required></td>
					</tr>
					<tr>
						<td>姓名:</td>
						<td><input type="text" pattern="^[\u4e00-\u9fff]{2,5}$"
							placeholder="請輸入中文名字" title="請輸入有效的中文，長度2到5個字"
							readonly="readonly" value="${emp.empName}" name="empName"
							id="empName" required></td>
					</tr>
					<tr>
						<td>性別:</td>
						<td style="text-align: center;"><input type="text"
							placeholder="請輸入性別" readonly="readonly" name="gender"
							value="${emp.gender}" required="required" id="" /> <select
							id="genderSelect" class="selectGender" style="display: none;">
								<option value="男">男</option>
								<option value="女">女</option>
						</select>
					</tr>
					<tr>
						<td>生日:</td>
						<td><input type="date" readonly="readonly"
							value="${emp.birth}" name="birth" id="birthdate" required></td>
					</tr>
				<thead>
					<th>聯絡資料</th>
					<th></th>
				</thead>
				<tr>
					<td>手機:</td>
					<td><input type="tel" pattern="[0-9]{10}"
						placeholder="請輸入手機號碼" title="請輸入有效長度，-不需輸入" readonly="readonly"
						value="${emp.contact.phone}" name="phone" required></td>
				</tr>
				<tr>
					<td>電話:</td>
					<td><input type="tel" pattern="[0-9]{9,10}" placeholder="市話選填"
						title="請輸入有效長度，-不需輸入" readonly="readonly"
						value="${emp.contact.tel}" name="tel"></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><input type="text" pattern="^[\u4e00-\u9fff0-9]+$"
						placeholder="請輸入地址" title="請輸入有效地址格式，僅限中文及數字" readonly="readonly"
						value="${emp.contact.address}" name="address" required></td>
				</tr>
				<tr>
					<td>信箱:</td>
					<td><input type="email"
						pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
						placeholder="請輸入電子信箱" title="請輸入有效格式，例:a123@gmail.com"
						readonly="readonly" value="${emp.contact.email}" name="email"
						required></td>
				</tr>
				<input type="hidden" name="emergencyCount"
					value="${emp.emergencies.size()}">
				<c:forEach items="${emp.emergencies}" var="emergency"
					varStatus="loop">
					<thead>
						<th>緊急連絡人</th>
						<th></th>
					</thead>
					<tr>
						<td><input type="hidden" readonly="readonly"
							value="${emergency.emergencyId}" name="emergencyId${loop.index}"
							required></td>
					</tr>
					<tr>
						<td>緊急聯絡人姓名:</td>
						<td><input type="text" pattern="^[\u4e00-\u9fff]{2,5}$"
							placeholder="請輸入中文名字" title="請輸入有效的中文，長度2到5個字"
							readonly="readonly" value="${emergency.emergencyName}"
							name="emergencyName${loop.index}" required></td>
					</tr>
					<tr>
						<td>緊急聯絡人電話:</td>
						<td><input type="tel" pattern="[0-9]{10}"
							placeholder="請輸入手機號碼" title="請輸入有效長度，-不需輸入" readonly="readonly"
							value="${emergency.emergencyPhone}"
							name="emergencyPhone${loop.index}" required></td>
					</tr>
					<tr>
						<td>聯絡人關係:</td>
						<td><input type="text" placeholder="請輸入與聯絡人關係"
							readonly="readonly" value="${emergency.emergencyRelationship}"
							name="emergencyRelationship${loop.index}" required></td>
					</tr>
				</c:forEach>

				</tbody>
			</table>
			<div class="but1">
			<button type="button" id="editButton">編輯</button>
			<button type="submit" id="saveButton" style="display: none;">儲存</button>
			<input type="hidden" value="${emp.empId}" id="empId">
			<button type="button" id="deleteButton">刪除資料</button>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$('#datatable').DataTable({
				"paging" : false,
				"searching" : false,
				"info" : false
			});

			$('#editButton').on('click', function() {
				$('#genderSelect').show().val($('input[name="gender"]').val());
				$('input[name="gender"]').hide();

				$('#inputPhoto').show();
				$('input').prop('readonly', function(i, readonly) {
					return !readonly;
				});
				$('#editButton').hide();
				$('#saveButton').show();
			});
			$('#saveButton').click(function() {
				if (window.confirm("確定要儲存嗎")) {
					let selectValue = $('#genderSelect').val();
					$('input[name="gender"]').val(selectValue);

				} else {
					return false;
				}
			});
			$(document).ready(function() {
				$('#deleteButton').on('click', function() {
					if (window.confirm("確定要刪除嗎")) {
						var empId = $('#empId').val();
						$.ajax({
							type : 'POST',
							url : '	DeleteEmp',
							data : {
								id : empId
							},
							success : function(response) {
								alert('刪除成功！');
								window.location.href = 'SelectAllEmp';
							},
							error : function(error) {
								alert('刪除失敗：' + error.responseText);
							}
						});
					} else {
					}
				});
			});
		});
	</script>
</body>
</html>