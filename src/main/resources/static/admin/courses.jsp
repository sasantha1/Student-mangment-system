<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Courses</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>Manage Courses</h2>
    <form action="/admin/courses/add" method="post">
        <label>Course Code:</label><input type="text" name="courseCode" required><br>
        <label>Course Name:</label><input type="text" name="courseName" required><br>
        <label>Teacher ID:</label><input type="number" name="teacherId" required><br>
        <button type="submit">Add Course</button>
    </form>
    <h3>Existing Courses</h3>
    <table>
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Teacher</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.courseCode}</td>
                <td>${course.courseName}</td>
                <td>${course.teacher.fullName}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>