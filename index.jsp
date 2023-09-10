
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
		<p>版權聲明©EIPULSE</p>
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
					<c:forEach items="${sessionScope.ls}" var="Permissionsemp"
						varStatus="s">
						<c:if test="${Permissionsemp == '1'}">
							<li><a href="javascript:void(0)" class="insert">新增</a></li>
						</c:if>
						<c:if test="${Permissionsemp == '2'}">
							<li><a href="javascript:void(0)" class="serach">查詢</a></li>
						</c:if>
					</c:forEach>
				</ul></li>


			<li><a href=""><img class="function" src="img/formtable.png" />表單申請</a></li>


			<li><a href=""><img class="function" src="img/meeting.png" />會議預約</a></li>

			<li><a href=""><img class="function" src="img/money.png" />薪資明細</a></li>


			<li><a href=""><img class="function" src="img/piggy.png" />福委資訊</a></li>
		</ul>

	</div>
	<script>
    document.querySelector('.toggleSubmenu').addEventListener('click', function () {
        let submenu = document.querySelector('.submenu');
        submenu.style.display = (submenu.style.display === 'block') ? 'none' : 'block';
    });
    document.querySelector(".insert").addEventListener("click",()=>{	
        document.querySelector("iframe").src = "insertemp.jsp"
        document.querySelector(".iframe1").style.display = "block";
    });
    document.querySelector(".serach").addEventListener("click",()=>{
        document.querySelector(".iframe1").style.display = "block";
        document.querySelector("iframe").src = "SelectAllEmp"
    });
</script>
</body>
</html>
