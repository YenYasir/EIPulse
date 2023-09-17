
<%
if (session.getAttribute("EmpId") == null) {
	response.sendRedirect("login.jsp");
}
%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>EIPULSE</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="CSS/index.css" />
</head>
<body>
	<div class="topBar">
		<img src="img/toplogo.png" class="toplogo" />
		<div class="username">
			<h4>員工編號：${sessionScope.EmpId}</h4>
			<a href="logout" style="color: whitesmoke;">登出</a>
			<%--        <div class="login-text-wrapper "></div>--%>
		</div>

	</div>
	<div class="backgrou">
		<iframe class="iframe1">
			<img src="../img/backgrou.jpg">
		</iframe>
	</div>
	<div class="down">
		<p class="downtext">版權聲明&nbsp©&nbspEIPULSE</p>
	</div>
	<div>
		<div class="functionBar">
			<img src="img/icon.jpg" /> 功能清單
		</div>

		<ul class="menu">
			<li><a href=""><img class="function" src="img/checkout.png" />打卡系統</a></li>

			<li><a href="javascript:void(0);" class="toggleSubmenu"> <img
					class="function" src="img/person.png" />人事資料
			</a>
				<ul class="submenu">
					<c:if test="${sessionScope.insertEmp == 1}">
						<li><a href="javascript:void(0)" id="insert">新增員工</a></li>
					</c:if>
					<c:if test="${sessionScope.selectEmp == 1}">
						<li><a href="javascript:void(0)" id="search">查詢員工</a></li>
					</c:if>
					<c:if test="${sessionScope.selectperEmp == 1}">
						<li><a href="javascript:void(0)" id="searchper">查詢員工權限</a></li>
					</c:if>
					<c:if test="${sessionScope.updateperEmp == 1}">
						<li><a href="javascript:void(0)" id="updateper">調整員工權限</a></li>
					</c:if>
				</ul></li>


			<li><a href=""><img class="function" src="img/formtable.png" />表單申請</a>
				<ui>
				<li><a href="javascript:void(0)" id="CheckFormStatus">查看表單狀態</a></li>
				<li><a href="javascript:void(0)" id="FillOutForms">寫表單</a></li>
				<li><a href="javascript:void(0)" id="ReviewForms">批審表單</a></li>
				
				</ui>
			</li>
				

			<li><a href=""><img class="function" src="img/meeting.png" />會議預約</a></li>

			<li><a href=""><img class="function" src="img/money.png" />薪資明細</a></li>


			<li><a href=""><img class="function" src="img/piggy.png" />福委資訊</a></li>
		</ul>

	</div>
	<script>
		document
				.querySelector('.toggleSubmenu')
				.addEventListener(
						'click',
						function() {
							let submenu = document.querySelector('.submenu');
							submenu.style.display = (submenu.style.display === 'block') ? 'none'
									: 'block';
						});
		if (document.getElementById("insert") != null) {
			document.getElementById('insert').addEventListener('click',function() {
								document.querySelector("iframe").src = "insertemp.jsp"
								document.querySelector(".iframe1").style.display = "block";
							});
		};
		if (document.getElementById("search") != null) {
			document
					.getElementById('search')
					.addEventListener(
							'click',
							function() {
								document.querySelector(".iframe1").style.display = "block";
								document.querySelector("iframe").src = "SelectAllEmp"
							});
		};
		if (document.getElementById("searchper") != null) {
			document
					.getElementById('searchper')
					.addEventListener(
							'click',
							function() {
								document.querySelector(".iframe1").style.display = "block";
								document.querySelector("iframe").src = "permissionEmp"
							});
		};
		
		if (document.getElementById("CheckFormStatus") != null) {
			document
					.getElementById('CheckFormStatus')
					.addEventListener(
							'click',
							function() {
								document.querySelector(".iframe1").style.display = "block";
								document.querySelector("iframe").src = "selectmyform"
							});
		};
		if (document.getElementById("FillOutForms") != null) {
			document
					.getElementById('FillOutForms')
					.addEventListener(
							'click',
							function() {
								document.querySelector(".iframe1").style.display = "block";
								document.querySelector("iframe").src = "fillOutForms"
							});
		};
		if (document.getElementById("ReviewForms") != null) {
			document
					.getElementById('ReviewForms')
					.addEventListener(
							'click',
							function() {
								document.querySelector(".iframe1").style.display = "block";
								document.querySelector("iframe").src = "reviewForms"
							});
		};
	</script>
</body>
</html>
