<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <title>SỬA SINH VIÊN</title>
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 20px;
        }
        .card {
            margin-top: 20px;
        }
        .card-header {
            background-color: #007bff;
            color: white;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .btn-success {
            width: 100%;
        }
    </style>
</head>
<body>
    <c:set var="student" value="${student}" scope="request" />
    <div class="container">
        <div class="card">
            <div class="card-header text-center">
                <h2>SỬA SINH VIÊN</h2>
            </div>
            <div class="card-body">
                <form action="editStudent" method="POST">
                    <div class="form-group">
                        <label for="ID">ID:</label>
                        <input id="ID" value="${student.id}" name="ID" class="form-control" readonly />
                    </div>
                    <div class="form-group">
                        <label for="first-name">Họ:</label>
                        <input id="first-name" value="${student.firstName}" class="form-control" name="firstName" required />
                    </div>
                    <div class="form-group">
                        <label for="second-name">Tên:</label>
                        <input id="second-name" value="${student.secondName}" class="form-control" name="secondName" required />
                    </div>
                    <div class="form-group">
                        <label for="address">Địa Chỉ:</label>
                        <input id="address" value="${student.address}" class="form-control" name="address" required />
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-success">UPDATE</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script>
    // Add any JavaScript here if needed
</script>
</html>
