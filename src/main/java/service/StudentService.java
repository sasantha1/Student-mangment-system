package com.student.managementsystem.service;

import com.student.managementsystem.entity.Student;
import com.student.managementsystem.entity.User;
import com.student.managementsystem.exception.ResourceNotFoundException;
import com.student.managementsystem.repository.StudentRepository;
import com.student.managementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public StudentService(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public Student createStudent(User user, String fullName, String studentId, String phone) {
        Student student = new Student();
        student.setUser(user);
        student.setFullName(fullName);
        student.setStudentId(studentId);
        student.setPhone(phone);
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));
    }
}