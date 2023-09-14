<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登入失敗</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="CSS/loginerror.css"/>
</head>
<body>
<div class="topBar"><img src="img/toplogo.png" class="toplogo"/></div>
<div class="loginform" >
    <div class="login">
        <h4 class="toptext">登入失敗</h4>
    </div>
    <h3 style="color: red">無效的帳號密碼</h3>

    <button type="button" class="loginbtn " onclick="window.location.href='login.jsp'">返回</button>
</div>
	<div class="down">
		<p class="downtext">版權聲明&nbsp©&nbspEIPULSE</p>
	</div>

</body>
</html>
