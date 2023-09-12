<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="CSS/insertempsuccess.css"/>
</head>
<body>
<div class="div1">
    <form id="editForm" method="post" action="SelectAllEmp" enctype="multipart/form-data">
        <table id="datatable" class="display">
            <thead>
      
            <tr>
                <th colspan="2" class="title">員工資料
               <input type="hidden"  readonly value="${emp.photo}" name="photo"></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>員工編號</td>
                <td><input type="text" readonly value="${emp.empId}" name="id"></td>
            </tr>
            <tr>
                <td>身分證字號</td>
                <td><input type="text" readonly value="${emp.idNumber}" name="idNumber"></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" readonly value="${emp.empName}" name="empName"></td>
            </tr>
            <tr>
                <td>性別</td>
                <td><input type="text" readonly value="${emp.gender}" name="gender"></td>
            </tr>
            <tr>
                <td>生日</td>
                <td><input type="text" readonly value="${emp.birth}" name="birth"></td>
            </tr>
            <thead>
            <th colspan="2">聯絡資料</th>
            </thead>
            <tr>
                <td>手機</td>
                <td><input type="text" readonly value="${emp.contact.phone}" name="phone"></td>
            </tr>
            <tr>
                <td>電話</td>
                <td><input type="text" readonly value="${emp.contact.tel}" name="tel"></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><input type="text" readonly value="${emp.contact.address}" name="address"></td>
            </tr>
            <tr>
                <td>信箱</td>
                <td><input type="text" readonly value="${emp.contact.email}" name="email"></td>
            </tr>
            <input type="hidden" name="emergencyCount" value="${emp.emergencies.size()}">
            <c:forEach items="${emp.emergencies}" var="emergency" varStatus="loop">
                <thead>
                <th colspan="2">緊急連絡人</th>
                </thead>
                <tr>
                    <td colspan="2"><input type="hidden" readonly value="${emergency.emergencyId}" name="emergencyId${loop.index}"></td>
                </tr>
                <tr>
                    <td>緊急聯絡人姓名</td>
                    <td><input type="text" readonly value="${emergency.emergencyName}" name="emergencyName${loop.index}"></td>
                </tr>
                <tr>
                    <td>緊急聯絡人電話</td>
                    <td><input type="text" readonly value="${emergency.emergencyPhone}" name="emergencyPhone${loop.index}"></td>
                </tr>
                <tr>
                    <td>聯絡人關係</td>
                    <td><input type="text" readonly value="${emergency.emergencyRelationship}" name="emergencyRelationship${loop.index}"></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div class="but1">
          <button type="submit" value="返回">返回</button>
        </div> 
    </form>
</div>
<script>
    $(document).ready(function () {
        $('#datatable').DataTable({
            "paging": false, 
            "searching": false,
            "info": false 
        });

        $('#editButton').on('click', function () {

            $('input[type="text"]').prop('readonly', function (i, readonly) {
                return !readonly;
            });

            $('#editButton').hide();
            $('#saveButton').show();
        });
        $('#saveButton').click(function () {
            if(window.confirm("確定要儲存嗎")){

            }else {
                return false;
            }
        });
        $('#rollback').click(function () {
            window.location.href = 'SelectAllEmp'; 
        });
    });
</script>
</body>
</html>
