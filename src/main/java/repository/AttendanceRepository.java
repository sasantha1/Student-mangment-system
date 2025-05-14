package com.student.managementsystem.repository;

import com.student.managementsystem.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByStudentIdAndCourseId(Long studentId, Long courseId);
    List<Attendance> findByStudentId(Long studentId);
}