<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            margin-top: 20px;
        }
        .card-header {
            background-color: #007bff;
            color: white;
        }
        .form-inline .form-control {
            margin-right: 10px;
        }
        .btn {
            margin-right: 10px;
        }
        .table th, .table td {
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <div class="container">
        <c:set var="list" value="${requestScope.listStudent}" />
        <div class="card">
            <div class="card-header">
                <h3>List Sinh Viên</h3>
            </div>
            <div class="card-body">
                <div class="row mb-3">
                    <form action="searchStudent" class="form-inline col-9">
                        <input type="text" name="id" class="form-control" placeholder="ID" value="${requestScope.ID == null ? '' : requestScope.ID}" />
                        <input type="text" name="name" class="form-control" placeholder="Tên" value="${requestScope.fullname == null ? '' : requestScope.fullname}" />
                        <input type="text" name="address" class="form-control" placeholder="Địa Chỉ" value="${requestScope.address == null ? '' : requestScope.address}" />
                        <input type="submit" value="SEARCH" class="btn btn-primary" />
                      
                    </form>
                    <div class="col-3 text-right">
                        <a href="addStudent" class="btn btn-outline-success">Thêm Sinh Viên +</a>
                    </div>
                </div>
                <table class="table table-bordered table-hover">
                    <thead class="thead-light">
                        <tr>
                            <th style="text-align: center">ID</th>
                            <th style="text-align: center">Họ</th>
                            <th style="text-align: center">Tên</th>
                            <th style="text-align: center">Địa Chỉ</th>
                            <th style="text-align: center" colspan="2">Chức Năng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="student" items="${list}">
                            <tr style="text-align: center">
                                <td><c:out value="${student.id}" /></td>
                                <td><c:out value="${student.firstName}" /></td>
                                <td><c:out value="${student.secondName}" /></td>
                                <td><c:out value="${student.address}" /></td>
                                <td><a class="btn btn-warning" href="editStudent?id=${student.id}">Edit</a></td>
                                <td><a class="btn btn-danger" href="deleteStudent?id=${student.id}">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
