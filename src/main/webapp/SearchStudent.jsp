<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.databasesClasses.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background:#f4f6f9;
}

.card{
    max-width:800px;
    margin:50px auto;
    border-radius:15px;
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

        <div class="card-header bg-primary text-white">
            <h3>Search Student</h3>
        </div>

        <div class="card-body">

            <form action="searchStudent" method="post">

                <div class="mb-3">
                    <label class="form-label">Enter SRN</label>

                    <input type="text"
                           name="srn"
                           class="form-control"
                           placeholder="Enter Student SRN"
                           required>
                </div>

                <button type="submit"
                        class="btn btn-primary">
                    Search
                </button>

                <a href="Welcome"
                   class="btn btn-secondary">
                    Back
                </a>

            </form>

            <hr>

            <%
            Student student =
                (Student)request.getAttribute("student");

            if(student != null){
            %>

            <h4 class="text-success mb-3">
                Student Details
            </h4>

            <table class="table table-bordered">

                <tr>
                    <th>SRN</th>
                    <td><%= student.getSrn() %></td>
                </tr>

                <tr>
                    <th>First Name</th>
                    <td><%= student.getFirstName() %></td>
                </tr>

                <tr>
                    <th>Last Name</th>
                    <td><%= student.getLastName() %></td>
                </tr>

                <tr>
                    <th>Age</th>
                    <td><%= student.getAge() %></td>
                </tr>

                <tr>
                    <th>Branch</th>
                    <td><%= student.getBranch() %></td>
                </tr>

            </table>

            <%
            }

            String msg =
                (String)request.getAttribute("msg");

            if(msg != null){
            %>

            <div class="alert alert-danger mt-3">
                <%= msg %>
            </div>

            <%
            }
            %>

        </div>

    </div>

</div>

</body>
</html>