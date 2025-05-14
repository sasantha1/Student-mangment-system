<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css">
</head>
<body>
<div class="container">
    <!-- Sidebar -->
    <nav class="sidebar">
        <div class="sidebar-header">
            <h2>Student Management</h2>
        </div>
        <ul>
            <li><a href="${pageContext.request.contextPath}/teacher/dashboard" class="active">Dashboard</a></li>
            <li><a href="${pageContext.request.contextPath}/teacher/grades">Manage Grades</a></li>
            <li><a href="${pageContext.request.contextPath}/teacher/attendance">Manage Attendance</a></li>
            <li><a href="${pageContext.request.contextPath}/teacher/announcements">Announcements</a></li>
            <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <div class="main-content">
        <!-- Header -->
        <header class="header">
            <h1>Teacher Dashboard</h1>
            <div class="user-info">
                <span>${teacherFullName}</span>
            </div>
        </header>

        <!-- Dashboard Content -->
        <div class="dashboard-content">
            <!-- Metrics Cards -->
            <section class="card">
                <h2>Total Courses</h2>
                <div class="card-content">
                    <p><strong>${courses.size()}</strong></p>
                </div>
            </section>
            <section class="card">
                <h2>New Announcements</h2>
                <div class="card-content">
                    <p><strong>${announcements.size()}</strong></p>
                </div>
            </section>
            <section class="card">
                <h2>Students Enrolled</h2>
                <div class="card-content">
                    <p><strong>0</strong> <!-- Placeholder; requires student count logic --></p>
                </div>
            </section>
            <section class="card">
                <h2>Attendance Marked</h2>
                <div class="card-content">
                    <p><strong>0</strong> <!-- Placeholder; requires attendance count logic --></p>
                </div>
            </section>

            <!-- Charts Section -->
            <section class="card">
                <h2>Course Visitors</h2>
                <div class="card-content">
                    <p>Placeholder for chart (e.g., using Chart.js)</p>
                    <!-- Add Chart.js or similar library for dynamic charts -->
                </div>
            </section>
            <section class="card">
                <h2>Weekly Activity</h2>
                <div class="card-content">
                    <p>Placeholder for chart (e.g., using Chart.js)</p>
                    <!-- Add Chart.js or similar library for dynamic charts -->
                </div>
            </section>
        </div>
    </div>
</div>

<!-- Include Chart.js for charts (optional) -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    // Placeholder chart initialization (to be implemented)
    // Example: new Chart(ctx, { type: 'line', data: {...} });
</script>
</body>
</html>