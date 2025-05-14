package com.student.managementsystem.controller;

import com.student.managementsystem.entity.Teacher;
import com.student.managementsystem.entity.User;
import com.student.managementsystem.repository.TeacherRepository;
import com.student.managementsystem.repository.UserRepository;
import com.student.managementsystem.service.AnnouncementService;
import com.student.managementsystem.service.AttendanceService;
import com.student.managementsystem.service.CourseService;
import com.student.managementsystem.service.GradeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final CourseService courseService;
    private final GradeService gradeService;
    private final AttendanceService attendanceService;
    private final AnnouncementService announcementService;
    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository;

    public TeacherController(CourseService courseService, GradeService gradeService,
                             AttendanceService attendanceService, AnnouncementService announcementService,
                             UserRepository userRepository, TeacherRepository teacherRepository) {
        this.courseService = courseService;
        this.gradeService = gradeService;
        this.attendanceService = attendanceService;
        this.announcementService = announcementService;
        this.userRepository = userRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/grades")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public String manageGrades(Model model, Authentication authentication) {
        Long teacherId = getTeacherId(authentication);
        model.addAttribute("courses", courseService.getCoursesByTeacher(teacherId));
        return "teacher/grades";
    }

    @PostMapping("/grades/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public String addGrade(@RequestParam Long studentId, @RequestParam Long courseId,
                           @RequestParam double score, @RequestParam String grade) {
        gradeService.createGrade(studentId, courseId, score, grade);
        return "redirect:/teacher/grades";
    }

    @GetMapping("/attendance")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public String manageAttendance(Model model, Authentication authentication) {
        Long teacherId = getTeacherId(authentication);
        model.addAttribute("courses", courseService.getCoursesByTeacher(teacherId));
        return "teacher/attendance";
    }

    @PostMapping("/attendance/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public String markAttendance(@RequestParam Long studentId, @RequestParam Long courseId,
                                 @RequestParam boolean present) {
        attendanceService.markAttendance(studentId, courseId, present);
        return "redirect:/teacher/attendance";
    }

    @GetMapping("/announcements")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public String manageAnnouncements(Model model) {
        model.addAttribute("announcements", announcementService.getRecentAnnouncements());
        return "teacher/announcements";
    }

    @PostMapping("/announcements/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public String postAnnouncement(@RequestParam String title, @RequestParam String content,
                                   Authentication authentication) {
        Long teacherId = getTeacherId(authentication);
        announcementService.createAnnouncement(teacherId, title, content);
        return "redirect:/teacher/announcements";
    }

    private Long getTeacherId(Authentication authentication) {
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        if (!user.getRole().equals(User.Role.TEACHER) && !user.getRole().equals(User.Role.ADMIN)) {
            throw new SecurityException("Access denied: User '" + username + "' is not authorized as a teacher or admin");
        }

        Teacher teacher = teacherRepository.findByUser(user)
                .orElseThrow(() -> new IllegalStateException("No teacher record found for user: " + username));
        return teacher.getId();
    }
}