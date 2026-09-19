<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container">
    <div class="card shadow mt-5 mx-auto" style="max-width:500px;">
        <div class="card-body">

            <h2 class="text-center mb-4">Register</h2>

            <form action="register" method="post">

                <div class="mb-3">
                    <label>Name</label>
                    <input type="text"
                           name="name"
                           class="form-control"
                           required>
                </div>

                <div class="mb-3">
                    <label>Email</label>
                    <input type="email"
                           name="email"
                           class="form-control"
                           required>
                </div>

                <div class="mb-3">
                    <label>Username</label>
                    <input type="text"
                           name="username"
                           class="form-control"
                           value="${param.username}"
                           required>
                            <small style="color:red;">
						        ${usernameError}
						    </small>
                </div>

                <div class="mb-3">
                    <label>Password</label>
                    <input type="password"
                           name="password"
                           class="form-control"
                           required>
                </div>

                <button class="btn btn-success w-100">
                    Register
                </button>

            </form>

            <div class="text-center mt-3">
                Already have an account?
                <a href="Login.jsp">Login</a>
            </div>

        </div>
    </div>
</div>

</body>
</html>