<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <style>
        .div1 {
            width: 80%;
            border: 2px double black;
            margin: auto;
        }

  
        .edit-field {
            display: none;
        }
    </style>
</head>
<body>
<div class="div1">
    <table id="datatable" class="display">
        <thead>
        <tr>
            <th>員工編號</th>
            <th>身分證字號</th>
            <th>姓名</th>
            <th>性別</th>
            <th>生日</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${emp}" var="emps">
            <tr>
                <td><span class="edit">${emps.id}</span><input type="text" class="edit-field" value="${emps.id}" /></td>
                <td><span class="edit">${emps.idNumber}</span><input type="text" class="edit-field" value="${emps.idNumber}" /></td>
                <td><span class="edit">${emps.empName}</span><input type="text" class="edit-field" value="${emps.empName}" /></td>
                <td><span class="edit">${emps.gender}</span><input type="text" class="edit-field" value="${emps.gender}" /></td>
                <td><span class="edit">${emps.birth}</span><input type="date" class="edit-field" value="${emps.birth}" /></td>
                <td><button class="update-button">編輯</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    $(document).ready(function () {
        $('#datatable').DataTable();


        $('#datatable').on('click', '.update-button', function () {
            const row = $(this).closest('tr');
            const editFields = row.find('.edit-field');
            const editSpans = row.find('.edit');

            editFields.toggle(); 
            editSpans.toggle(); 
        });
    });
</script>
</body>
</html>
