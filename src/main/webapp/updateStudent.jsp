<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

body{
    background:#f4f6f9;
}

.update-card{
    max-width:800px;
    margin:40px auto;
    border-radius:15px;
}

.card-header{
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

    <div class="card shadow update-card">

        <div class="card-header">
            <h3 class="text-center">
                Update Student Details
            </h3>
        </div>

        <div class="card-body">

            <form action="updateStudent" method="post">

                <!-- SRN -->

                <div class="mb-3">

                    <label class="form-label">
                        Student SRN
                    </label>

                    <input type="text"
                           name="srn"
                           class="form-control"
                           value="${student.srn}"
                           >

                </div>

                <!-- First Name -->

                <div class="mb-3">

                    <label class="form-label">
                        First Name
                    </label>

                    <input type="text"
                           name="firstName"
                           class="form-control"
                           value="${student.firstName}">

                </div>

                <!-- Last Name -->

                <div class="mb-3">

                    <label class="form-label">
                        Last Name
                    </label>

                    <input type="text"
                           name="lastName"
                           class="form-control"
                           value="${student.lastName}">

                </div>

                <!-- Age -->

                <div class="mb-3">

                    <label class="form-label">
                        Age
                    </label>

                    <input type="number"
                           name="age"
                           class="form-control"
                           value="${student.age}"
                           min="16"
                           max="60">

                </div>

                <!-- Branch -->

                <div class="mb-3">

                    <label class="form-label">
                        Branch
                    </label>

                    <select name="branch"
                            class="form-select">

                        <option value="CSE"
                            ${student.branch=='CSE'?'selected':''}>
                            CSE
                        </option>

                        <option value="ECE"
                            ${student.branch=='ECE'?'selected':''}>
                            ECE
                        </option>

                        <option value="EEE"
                            ${student.branch=='EEE'?'selected':''}>
                            EEE
                        </option>

                        <option value="MECH"
                            ${student.branch=='MECH'?'selected':''}>
                            MECH
                        </option>

                        <option value="CIVIL"
                            ${student.branch=='CIVIL'?'selected':''}>
                            CIVIL
                        </option>

                    </select>

                </div>

                <!-- Buttons -->

                <div class="d-flex gap-2">

                    <button type="submit"
                            class="btn btn-success">
                        Update Student
                    </button>

                    <a href="Welcome"
                       class="btn btn-secondary">
                        Back
                    </a>

                </div>

            </form>

        </div>

    </div>

</div>

</body>
</html>