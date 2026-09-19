<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Students</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

body{
    background:#f4f6f9;
}

.card{
    margin-top:40px;
    border:none;
    border-radius:15px;
}

.table{
    vertical-align:middle;
}

.header{
    background:#0d6efd;
    color:white;
}

</style>

</head>
<body>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

if(session.getAttribute("userName")==null){
    response.sendRedirect("Login.jsp");
    return;
}
%>
<div class="container">

    <div class="card shadow">

        <div class="card-header header">

            <div class="d-flex justify-content-between">

                <h3>Student Records</h3>

                <a href="Welcome"
                   class="btn btn-light">
                    Dashboard
                </a>

            </div>

        </div>

        <div class="card-body">

            <c:if test="${empty students}">

                <div class="alert alert-warning">
                    No Students Found
                </div>

            </c:if>

            <c:if test="${not empty students}">

                <table class="table table-bordered table-hover">

                    <thead class="table-dark">

                        <tr>
                            <th>SRN</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Age</th>
                            <th>Branch</th>
                            <th>Actions</th>
                        </tr>

                    </thead>

                    <tbody>

                        <c:forEach items="${students}" var="s">

                            <tr>

                                <td>${s.srn}</td>

                                <td>${s.firstName}</td>

                                <td>${s.lastName}</td>

                                <td>${s.age}</td>

                                <td>${s.branch}</td>

                                <td>

                                    <a href="editStudent?srn=${s.srn}"
                                       class="btn btn-warning btn-sm">
                                        Edit
                                    </a>

                                    <a href="deleteStudentForward?srn=${s.srn}"
                                       class="btn btn-danger btn-sm"
                                       onclick="return confirm('Are you sure you want to delete this student?')">
                                        Delete
                                    </a>

                                </td>

                            </tr>

                        </c:forEach>

                    </tbody>

                </table>

            </c:if>

        </div>

    </div>

</div>

</body>
</html>