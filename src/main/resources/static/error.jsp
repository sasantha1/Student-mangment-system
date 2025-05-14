<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h2>Error</h2>
    <p>Status: ${status}</p>
    <p>Message: ${errorMessage}</p>
    <a href="/dashboard">Back to Dashboard</a>
</div>
</body>
</html>