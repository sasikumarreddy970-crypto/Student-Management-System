<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
    background:#f4f6f9;
}

.sidebar{
    height:100vh;
    background:#212529;
    color:white;
    position:fixed;
    width:250px;
}

.sidebar h3{
    padding:20px;
    text-align:center;
    border-bottom:1px solid #444;
}

.sidebar a{
    display:block;
    color:white;
    text-decoration:none;
    padding:15px 20px;
}

.sidebar a:hover{
    background:#0d6efd;
}

.main{
    margin-left:250px;
    padding:20px;
}

.card{
    border:none;
    border-radius:15px;
    transition:.3s;
}

.card:hover{
    transform:translateY(-5px);
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
<!-- Sidebar -->

<div class="sidebar">

    <h3> SMS Admin</h3>

    <a href="AddStudent.jsp"> Add Student</a>

    <a href="viewStudent"> View Students</a>

    <a href="SearchStudent.jsp"> Search Student</a>

    <a href="updateStudent.jsp"> Update Student</a>

    <a href="DeleteStudent.jsp">Delete Student</a>

    <a href="logoutFromSession"> Logout</a>

</div>

<!-- Main Content -->

<div class="main">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <h2>Dashboard</h2>

        <h5>
            Welcome,
            <span class="text-primary">
                ${name}
            </span>
        </h5>

    </div>

    <!-- Statistics -->

    <div class="row">

        <div class="col-md-4">
            <div class="card shadow p-3">
                <h5>Total Students</h5>
                <h2 class="text-primary">
                    ${totalStudents}
                </h2>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card shadow p-3">
                <h5>Active Users</h5>
                <h2 class="text-success">
                    ${activeUsers}
                </h2>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card shadow p-3">
                <h5>Courses</h5>
                <h2 class="text-danger">
                    ${totalCourses}
                </h2>
            </div>
        </div>

    </div>

    <!-- Quick Actions -->

    <div class="row mt-4">

        <div class="col-md-6">
            <div class="card shadow p-4">
                <h4>Add New Student</h4>
                <p>Create student records.</p>

                <a href="AddStudent.jsp"
                   class="btn btn-primary">
                    Add Student
                </a>
            </div>
        </div>

        <div class="col-md-6">
            <div class="card shadow p-4">
                <h4>Manage Students</h4>
                <p>View, update and delete records.</p>

                <a href="ManageStudents.jsp"
                   class="btn btn-success">
                    Manage Students
                </a>
            </div>
        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>