<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Attendance</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>My Attendance</h2>
    <table>
        <tr>
            <th>Course</th>
            <th>Date</th>
            <th>Status</th>
        </tr>
        <c:forEach var="attendance" items="${attendance}">
            <tr>
                <td>${attendance.course.courseName}</td>
                <td>${attendance.date}</td>
                <td>${attendance.present ? 'Present' : 'Absent'}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>