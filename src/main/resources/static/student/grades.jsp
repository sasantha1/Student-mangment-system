<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Grades</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>My Grades</h2>
    <table>
        <tr>
            <th>Course</th>
            <th>Score</th>
            <th>Grade</th>
        </tr>
        <c:forEach var="grade" items="${grades}">
            <tr>
                <td>${grade.course.courseName}</td>
                <td>${grade.score}</td>
                <td>${grade.grade}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>