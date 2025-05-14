<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Profile</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>Student Profile</h2>
    <p><strong>Name:</strong> ${student.fullName}</p>
    <p><strong>Student ID:</strong> ${student.studentId}</p>
    <p><strong>Phone:</strong> ${student.phone}</p>
    <p><strong>Email:</strong> ${student.user.email}</p>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>