package com.student.managementsystem.service;

import com.student.managementsystem.dto.TeacherDTO;
import com.student.managementsystem.entity.Teacher;
import com.student.managementsystem.entity.User;
import com.student.managementsystem.exception.ResourceNotFoundException;
import com.student.managementsystem.repository.TeacherRepository;
import com.student.managementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;

    public TeacherService(TeacherRepository teacherRepository, UserRepository userRepository) {
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        User user = userRepository.findById(teacherDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + teacherDTO.getUserId()));
        if (user.getRole() != User.Role.TEACHER) {
            throw new IllegalArgumentException("User must have TEACHER role");
        }

        Teacher teacher = new Teacher();
        teacher.setUser(user);
        teacher.setFullName(teacherDTO.getFullName());
        teacher.setDepartment(teacherDTO.getDepartment());
        Teacher savedTeacher = teacherRepository.save(teacher);

        teacherDTO.setId(savedTeacher.getId());
        return teacherDTO;
    }

    public TeacherDTO getTeacherByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        Teacher teacher = teacherRepository.findByUser(user)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found for user id: " + userId));
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setUserId(teacher.getUser().getId());
        teacherDTO.setFullName(teacher.getFullName());
        teacherDTO.setDepartment(teacher.getDepartment());
        teacherDTO.setEmail(user.getEmail());
        return teacherDTO;
    }

    public void createTeacher(com.student.managementsystem.entity.User user, String fullName, String department) {
    }
}