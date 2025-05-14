package controller;

import com.student.managementsystem.entity.Course;
import com.student.managementsystem.entity.Student;
import com.student.managementsystem.entity.Teacher;
import com.student.managementsystem.entity.User;
import com.student.managementsystem.service.CourseService;
import com.student.managementsystem.service.StudentService;
import com.student.managementsystem.service.TeacherService;
import com.student.managementsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final CourseService courseService;

    public AdminController(UserService userService, StudentService studentService,
                           TeacherService teacherService, CourseService courseService) {
        this.userService = userService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String username, @RequestParam String password,
                          @RequestParam String role, @RequestParam String email,
                          @RequestParam String fullName, @RequestParam String idNumber,
                          @RequestParam String phone, @RequestParam String department) {
        User user = userService.registerUser(username, password, role, email);
        if (role.equals("STUDENT")) {
            studentService.createStudent(user, fullName, idNumber, phone);
        } else if (role.equals("TEACHER")) {
            teacherService.createTeacher(user, fullName, department);
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "admin/courses";
    }

    @PostMapping("/courses/add")
    public String addCourse(@RequestParam String courseCode, @RequestParam String courseName,
                            @RequestParam Long teacherId) {
        courseService.createCourse(courseCode, courseName, teacherId);
        return "redirect:/admin/courses";
    }
}