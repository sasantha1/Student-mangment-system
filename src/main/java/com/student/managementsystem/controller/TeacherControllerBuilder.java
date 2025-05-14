package com.student.managementsystem.controller;

public class TeacherControllerBuilder {
    private com.student.managementsystem.service.CourseService courseService;
    private com.student.managementsystem.service.GradeService gradeService;
    private com.student.managementsystem.service.AttendanceService attendanceService;
    private com.student.managementsystem.service.AnnouncementService announcementService;
    private com.student.managementsystem.repository.UserRepository userRepository;
    private com.student.managementsystem.repository.TeacherRepository teacherRepository;

    public TeacherControllerBuilder setCourseService(com.student.managementsystem.service.CourseService courseService) {
        this.courseService = courseService;
        return this;
    }

    public TeacherControllerBuilder setGradeService(com.student.managementsystem.service.GradeService gradeService) {
        this.gradeService = gradeService;
        return this;
    }

    public TeacherControllerBuilder setAttendanceService(com.student.managementsystem.service.AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
        return this;
    }

    public TeacherControllerBuilder setAnnouncementService(com.student.managementsystem.service.AnnouncementService announcementService) {
        this.announcementService = announcementService;
        return this;
    }

    public TeacherControllerBuilder setUserRepository(com.student.managementsystem.repository.UserRepository userRepository) {
        this.userRepository = userRepository;
        return this;
    }

    public TeacherControllerBuilder setTeacherRepository(com.student.managementsystem.repository.TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
        return this;
    }

    public com.student.managementsystem.controller.TeacherController createTeacherController() {
        return new com.student.managementsystem.controller.TeacherController(courseService, gradeService, attendanceService, announcementService, userRepository, teacherRepository);
    }
}