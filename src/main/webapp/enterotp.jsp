<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>驗證碼輸入</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
  <link rel="stylesheet" href="CSS/enterotp.css"/>
</head>
<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
<div class="topBar"><img class="toplogo" src="img/toplogo.png" width="150px"/></div>
<div class="loginform" >
    <form action="validateotp" method="post">
        <div class="login">
            <h4 class="toptext">驗證碼輸入</h4>
            <h3>請輸入驗證碼以更改密碼
            </h3>
            驗證碼：<input type="text" class="otpinput" name="Otp" id="Otp" required>
            <button type="submit" class="loginbtn">重設密碼</button>
            <div class="back">
                <a href="login.jsp">返回登入介面</a>
            </div>
        </div>
    </form>
</div>
</div>
<div class="down"><p>版權聲明©EIPULSE</p></div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.min.js" integrity="sha384-Rx+T1VzGupg4BHQYs2gCW9It+akI2MM/mndMCy36UVfodzcJcF0GGLxZIzObiEfa"></script>
</body>
</html>