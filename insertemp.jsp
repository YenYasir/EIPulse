<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>

<style>
</style>

<link rel="stylesheet" href="CSS/insertemp.css" />
</head>
<body>
	<div class="div1">
		<h2 class="title">員工資料建立</h2>
		<div class="f">
			<form method="post" action="InsertEmp" enctype="multipart/form-data">
				<fieldset id="page1">
					<legend>基本資料</legend>
					<p>
						身分證字號：<input type="text" pattern="^[A-Z][0-9]{9}$"
							placeholder="請輸入身分證字號" title="請輸入有效身分證格式" required id="id"
							name="idNumber" />
					<p>
						姓名：<input type="text" pattern="^[\u4e00-\u9fff]{2,5}$"
							placeholder="請輸入中文名字" title="請輸入有效的中文，長度2到5個字" required id="name" name="empName" />
					<p>
						性別：<select name="gender" required>
							<option value="M">男</option>
							<option value="F">女</option>
						</select>
					<p>
						生日：<input type="date" required id="birth" name="birth" />
					<p>
						上傳大頭照：<input type="file" required name="photo" />
					<p>
						<label class="dept">部門：</label> <select name="detpid">
							<c:forEach items="${sessionScope.dept}" var="dept" varStatus="s">
								<option value="${dept.deptId}">${dept.deptName}</option>
							</c:forEach>
						</select>
					</P>
					<p>
						<label class="dept">職位：</label> <select name="titleid">
							<c:forEach items="${sessionScope.title}" var="title"
								varStatus="s">
								<option value="${title.titleId}">${title.titleName}</option>
							</c:forEach>
						</select>
					</p>
				</fieldset>
				<div
					style="display: flex; justify-content: center; align-items: center;">
					<button type="button" onclick="nextPage('page2')" id="nextBtn">下一頁</button>
				</div>

				<fieldset id="page2" style="display: none;">
					<legend>聯絡資料</legend>
					<p>
						手機：<input type="tel" pattern="[0-9]{10}"
						placeholder="請輸入手機號碼" title="請輸入有效長度，-不需輸入" required id="phone" name="phone" />
					<p>
						電話：<input type="tel" pattern="[0-9]{10}" placeholder="市話選填"
						title="請輸入有效長度，-不需輸入" id="tel" name="tel" />
					<p>
						地址：<input type="text" pattern="^[\u4e00-\u9fff0-9]+$"
						placeholder="請輸入地址" title="請輸入有效地址格式，僅限中文及數字" required id="address" name="address" />
					<p>
						信箱：<input type="email"
						pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}"
						placeholder="請輸入電子信箱" title="請輸入有效格式，例:a123@gmail.com" required  id="email" name="email" />
					<p>
						緊急聯絡人姓名：<input type="text" type="text" pattern="^[\u4e00-\u9fff]{2,5}$"
							placeholder="請輸入中文名字" title="請輸入有效的中文，長度2到5個字" required name="emergencyName" />
					<p>
						緊急聯絡人電話：<input type="tel" pattern="[0-9]{10}"
							placeholder="請輸入手機號碼" title="請輸入有效長度，-不需輸入" required name="emergencyPhone" />
					<p>
						聯絡人關係：<input type="text" name="emergencyRelationship" /> <br />
				</fieldset>
				<div
					style="display: flex; justify-content: center; align-items: center;">
					<button type="button" onclick="prevPage('page1')" id="prevBtn"
						style="display: none;">上一頁</button>
					<div style="margin: 0 10px;"></div>
					<input type="submit" value="提交" id="submitBtn"
						style="display: none;">
				</div>
			</form>
		</div>
	</div>

	<script>
		function showPage(pageId) {
			document.getElementById(pageId).style.display = "block";
		}

		function hidePage(pageId) {
			document.getElementById(pageId).style.display = "none";
		}

		function nextPage(nextPageId) {
			hidePage(currentPage);
			currentPage = nextPageId;
			showPage(currentPage);
			if (nextPageId === "page2") {
				document.getElementById('nextBtn').style.display = 'none';
				document.getElementById('prevBtn').style.display = 'block';
				document.getElementById('submitBtn').style.display = 'block';
			}
		}

		function prevPage(prevPageId) {
			hidePage(currentPage);
			currentPage = prevPageId;
			showPage(currentPage);
			if (currentPage === "page1") {
				document.getElementById('nextBtn').style.display = 'block';
				document.getElementById('prevBtn').style.display = 'none';
				document.getElementById('submitBtn').style.display = 'none';
			}
		}

		var currentPage = "page1"; //初始顯示第一頁
	</script>

</body>
</html>