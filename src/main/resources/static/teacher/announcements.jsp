<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Post Announcements</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>Post Announcements</h2>
    <form action="/teacher/announcements/add" method="post">
        <label>Title:</label><input type="text" name="title" required><br>
        <label>Content:</label><textarea name="content" required></textarea><br>
        <button type="submit">Post Announcement</button>
    </form>
    <h3>Recent Announcements</h3>
    <c:forEach var="announcement" items="${announcements}">
        <div class="announcement">
            <h4>${announcement.title}</h4>
            <p>${announcement.content}</p>
            <small>Posted on ${announcement.postedAt}</small>
        </div>
    </c:forEach>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>