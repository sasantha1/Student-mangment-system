<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>Manage Users</h2>
    <form action="/admin/users/add" method="post">
        <label>Username:</label><input type="text" name="username" required><br>
        <label>Password:</label><input type="password" name="password" required><br>
        <label>Role:</label>
        <select name="role" required>
            <option value="ADMIN">Admin</option>
            <option value="TEACHER">Teacher</option>
            <option value="STUDENT">Student</option>
        </select><br>
        <label>Email:</label><input type="email" name="email" required><br>
        <label>Full Name:</label><input type="text" name="fullName" required><br>
        <label>ID Number/Department:</label><input type="text" name="idNumber"><br>
        <label>Phone:</label><input type="text" name="phone"><br>
        <button type="submit">Add User</button>
    </form>
    <h3>Existing Users</h3>
    <table>
        <tr>
            <th>Username</th>
            <th>Role</th>
            <th>Email</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td>${user.role}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>