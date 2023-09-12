<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>EIPulse員工登入系統</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
<div class="topBar"><img src="img/toplogo.png" class="toplogo"/></div>
<div class="loginform">
    <form action="login" method="post">
        <div class="login">
            <h4 class="toptext">登入介面</h4>
            <div class="EmpId">員工代號：<input type="text" class="EmpIdInput" name="EmpId" id="EmpId" required value="1000"></div>
            <div class="PassWord">密碼：<input type="password" class="PassWordInput" name="PassWord" id="PassWord"  placeholder="預設西元生日末6碼" required value="100"></div>
            <br>
            <br>
            <button type="submit" class="loginbtn">登入</button>
        </div>
    </form>
    <div class="changepwd_rel">
        <div class="changepwd_ab"> <a href="forgotpassword.jsp">忘記密碼</a></div>
        <br>${err}
    </div>
</div>
	<div class="down">
		<p class="downtext">版權聲明&nbsp©&nbspEIPULSE</p>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"></script>
</body>
</html>
