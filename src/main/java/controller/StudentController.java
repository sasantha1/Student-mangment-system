package com.student.managementsystem.controller;

import com.student.managementsystem.service.AttendanceService;
import com.student.managementsystem.service.GradeService;
import com.student.managementsystem.service.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final GradeService gradeService;
    private final AttendanceService attendanceService;

    public StudentController(StudentService studentService, GradeService gradeService,
                             AttendanceService attendanceService) {
        this.studentService = studentService;
        this.gradeService = gradeService;
        this.attendanceService = attendanceService;
    }

    @GetMapping("/profile")
    public String viewProfile(Model model, Authentication authentication) {
        Long studentId = getStudentId(authentication);
        model.addAttribute("student", studentService.getStudentById(studentId));
        return "student/profile";
    }

    @GetMapping("/grades")
    public String viewGrades(Model model, Authentication authentication) {
        Long studentId = getStudentId(authentication);
        model.addAttribute("grades", gradeService.getGradesByStudent(studentId));
        return "student/grades";
    }

    @GetMapping("/attendance")
    public String viewAttendance(Model model, Authentication authentication) {
        Long studentId = getStudentId(authentication);
        model.addAttribute("attendance", attendanceService.getAttendanceByStudent(studentId));
        return "student/attendance";
    }

    private Long getStudentId(Authentication authentication) {
        // Implement logic to get student ID from authenticated user
        return 1L; // Placeholder
    }
}