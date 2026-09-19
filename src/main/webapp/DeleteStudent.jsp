<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>

body{
    background:#f4f6f9;
}

.delete-card{
    max-width:600px;
    margin:80px auto;
    border-radius:15px;
}

</style>

</head>
<body>
<%
if(session.getAttribute("userName")==null){
    response.sendRedirect("Login.jsp");
    return;
}
%>
<div class="container">

    <div class="card shadow delete-card">

        <div class="card-header bg-danger text-white">
            <h3 class="text-center">Delete Student</h3>
        </div>

        <div class="card-body">

            <form action="deleteStudent" method="post">

                <div class="mb-3">
                    <label class="form-label">
                        Student SRN
                    </label>

                    <input type="text"
                           name="srn"
                           class="form-control"
                           placeholder="Enter Student SRN"
                           value="${srn}"
                           required>

                    <small class="text-danger">
                        ${deleteError}
                    </small>
                     <small class="text-success">
                        ${acceptNote}
                    </small>
                </div>

                <div class="alert alert-warning">
                    ⚠ This action cannot be undone.
                </div>

                <button type="submit"
                        class="btn btn-danger">
                    Delete Student
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