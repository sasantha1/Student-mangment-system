<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mark Attendance</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>Mark Attendance</h2>
    <form action="/teacher/attendance/add" method="post">
        <label>Course:</label>
        <select name="courseId" required>
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}">${course.courseName}</option>
            </c:forEach>
        </select><br>
        <label>Student ID:</label><input type="number" name="studentId" required><br>
        <label>Present:</label><input type="checkbox" name="present"><br>
        <button type="submit">Mark Attendance</button>
    </form>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>