<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="bu()">小鈴鐺</button>
	<div id="bu1" style="display:none">
	<c:forEach items="${message}" var="m">
		<a href="${m.link}">${m.message} ${m.createdAt}</a>
		
		<br>
	</c:forEach>
	</div>
	<script>
        let a= 0;
        function bu(){
            
            if(a==0){
                document.getElementById("bu1").style.display="block";
                a=1;
            }else{
                document.getElementById("bu1").style.display="none";
                a=0;
            }
        }

    </script>
</body>
</html>