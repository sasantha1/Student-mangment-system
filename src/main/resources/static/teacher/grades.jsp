<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Grades</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>Manage Grades</h2>
    <form action="/teacher/grades/add" method="post">
        <label>Course:</label>
        <select name="courseId" required>
            <c:forEach var="course" items="${courses}">
                <option value="${course.id}">${course.courseName}</option>
            </c:forEach>
        </select><br>
        <label>Student ID:</label><input type="number" name="studentId" required><br>
        <label>Score:</label><input type="number" step="0.01" name="score" required><br>
        <label>Grade:</label><input type="text" name="grade" required><br>
        <button type="submit">Add Grade</button>
    </form>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>