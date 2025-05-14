package com.student.managementsystem.repository;

import com.student.managementsystem.entity.Teacher;
import com.student.managementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByUser(User user);
}