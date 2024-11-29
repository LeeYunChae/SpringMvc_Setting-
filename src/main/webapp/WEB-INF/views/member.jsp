<%--
  Created by IntelliJ IDEA.
  User: 이윤채
  Date: 2024-11-29
  Time: 오후 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Table</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>

<h2>User Table</h2>

<table>
    <thead>
    <tr>
        <th>User Index</th>
        <th>Name</th>
        <th>User ID</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Password</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iterate through the user list and display each user data -->
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.useridx}</td>
            <td>${user.name}</td>
            <td>${user.userid}</td>
            <td>${user.email}</td>
            <td>${user.phonenum}</td>
            <td>${user.pwd}</td>
            <td>${user.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>