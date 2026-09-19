<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System - Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background-color:#f8f9fa;
}

.login-card{
    width:400px;
    margin:auto;
    margin-top:100px;
    padding:30px;
    border-radius:15px;
    box-shadow:0 0 15px rgba(0,0,0,0.2);
    background:white;
}
</style>

</head>
<body>

<div class="container">

    <div class="login-card">

        <h2 class="text-center text-primary mb-4">
            Student Management System
        </h2>

        <form action="login" method="post">

    <div class="mb-3">
        <input type="text" name="username"
               class="form-control"
               placeholder="Username">
    </div>

    <div class="mb-3">
        <input type="password" name="password"
               class="form-control"
               placeholder="Password">
    </div>

    <button class="btn btn-primary w-100">
        Login
    </button>

</form>

<div class="text-center mt-3">
    Don't have an account?
    <a href="Register.jsp">Register Here</a>
</div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>