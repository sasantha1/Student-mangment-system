package com.student.managementsystem.service;

import com.student.managementsystem.dto.CourseDTO;
import com.student.managementsystem.entity.Course;
import com.student.managementsystem.entity.Teacher;
import com.student.managementsystem.repository.CourseRepository;
import com.student.managementsystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public CourseService(CourseRepository courseRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
    }

    private static CourseDTO apply(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCourseCode(course.getCourseCode());
        dto.setCourseName(course.getCourseName());
        dto.setTeacherId(course.getTeacher().getId());
        dto.setTeacherName(course.getTeacher().getFullName());
        return dto;
    }

    public List<CourseDTO> getCoursesByTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));
        List<Course> courses = courseRepository.findByTeacher(teacher);
        return courses.stream().map(CourseService::apply).collect(Collectors.toList());
    }

    public void createCourse(String courseCode, String courseName, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));
        Course course = new Course();
        course.setCourseCode(courseCode);
        course.setCourseName(courseName);
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(CourseService::apply).collect(Collectors.toList());
    }
}