package com.student.managementsystem.service;

import com.student.managementsystem.dto.AttendanceDTO;
import com.student.managementsystem.entity.Attendance;
import com.student.managementsystem.exception.ResourceNotFoundException;
import com.student.managementsystem.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public void markAttendance(Long studentId, Long courseId, boolean present) {
        Attendance attendance = new Attendance();
        attendance.setStudentId(studentId); // Note: Adjust if using direct entity reference
        attendance.setCourseId(courseId);   // Note: Adjust if using direct entity reference
        attendance.setDate(LocalDate.now());
        attendance.setPresent(present);
        attendanceRepository.save(attendance);
    }

    public AttendanceDTO getAttendance(Long studentId, Long courseId) {
        Attendance attendance = attendanceRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found for studentId: " + studentId + ", courseId: " + courseId));
        AttendanceDTO dto = new AttendanceDTO();
        dto.setId(attendance.getId());
        dto.setStudentId(attendance.getStudentId());
        dto.setCourseId(attendance.getCourseId());
        dto.setDate(attendance.getDate());
        dto.setPresent(attendance.isPresent());
        return dto;
    }

    public List<AttendanceDTO> getAttendanceByStudent(Long studentId) {
        List<Attendance> attendances = attendanceRepository.findByStudentId(studentId);
        return attendances.stream().map(attendance -> {
            AttendanceDTO dto = new AttendanceDTO();
            dto.setId(attendance.getId());
            dto.setStudentId(attendance.getStudentId());
            dto.setCourseId(attendance.getCourseId());
            dto.setDate(attendance.getDate());
            dto.setPresent(attendance.isPresent());
            return dto;
        }).collect(Collectors.toList());
    }
}