<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background:#f4f6f9;
}

.card{
    max-width:700px;
    margin:50px auto;
    border-radius:15px;
}
</style>

</head>
<body>

<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if(session.getAttribute("userName")==null){
		response.sendRedirect("Login.jsp");
	}
%>
<div class="container">

    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h3>Add Student</h3>
        </div>

        <div class="card-body">

            <form action="addStudent" method="post">

                <!-- SRN -->

                <div class="mb-3">
                    <label class="form-label">SRN</label>

                    <input type="text"
                           name="srn"
                           class="form-control"
                           value="${param.srn}"
                           required>

                    <small class="text-danger">
                        ${srnError}
                    </small>
                </div>

                <!-- First Name -->

                <div class="mb-3">
                    <label class="form-label">First Name</label>

                    <input type="text"
                           name="firstName"
                           class="form-control"
                           value="${param.firstName}"
                           required>
                </div>

                <!-- Last Name -->

                <div class="mb-3">
                    <label class="form-label">Last Name</label>

                    <input type="text"
                           name="lastName"
                           class="form-control"
                           value="${param.lastName}"
                           required>
                </div>

                <!-- Age -->

                <div class="mb-3">
                    <label class="form-label">Age</label>

                    <input type="number"
                           name="age"
                           class="form-control"
                           min="16"
                           max="60"
                           required>
                </div>

                <!-- Branch -->

                <div class="mb-3">
                    <label class="form-label">Branch</label>

                    <select name="branch"
                            class="form-select">

                        <option value="CSE">CSE</option>
                        <option value="ECE">ECE</option>
                        <option value="EEE">EEE</option>
                        <option value="MECH">MECH</option>
                        <option value="CIVIL">CIVIL</option>

                    </select>
                </div>

                <button class="btn btn-success">
                    Add Student
                </button>

                <a href="Welcome"
                   class="btn btn-secondary">
                    Back
                </a>

            </form>

        </div>

    </div>

</div>

</body>
</html>