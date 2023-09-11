<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="//cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
    <style>
        .div1 {
            width: 100%;
            /*border: 2px double black;*/
            margin: auto;
        }
    </style>
</head>
<body>
<div class="div1">
    <table id="datatable">
        <thead>
        <tr>
            <th>員工編號</th>
            <th>身分證字號</th>
            <th>姓名</th>
            <th>性別</th>
            <th>生日</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${emp}" var="emps">
            <tr>
                <td><a href="SelectById?id=${emps.empId}">${emps.empId}</a></td>
                <td>${emps.idNumber}</td>
                <td>${emps.empName}</td>
                <td>${emps.gender}</td>
                <td>${emps.birth}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    let table = $('#datatable').DataTable();
</script>
</body>
</html>
