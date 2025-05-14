package com.student.managementsystem.service;

import com.student.managementsystem.dto.GradeDTO;
import com.student.managementsystem.entity.Grade;
import com.student.managementsystem.exception.ResourceNotFoundException;
import com.student.managementsystem.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    private static GradeDTO apply(Grade grade) {
        GradeDTO dto = new GradeDTO();
        dto.setId(grade.getId());
        dto.setStudentId(grade.getStudentId());
        dto.setCourseId(grade.getCourseId());
        dto.setScore(grade.getScore());
        dto.setGrade(grade.getGrade());
        return dto;
    }

    public void createGrade(Long studentId, Long courseId, double score, String grade) {
        Grade gradeEntity = new Grade();
        gradeEntity.setStudentId(studentId); // Note: Adjust if using direct entity reference
        gradeEntity.setCourseId(courseId);   // Note: Adjust if using direct entity reference
        gradeEntity.setScore(score);
        gradeEntity.setGrade(grade);
        gradeRepository.save(gradeEntity);
    }

    public GradeDTO getGrade(Long studentId, Long courseId) {
        Grade grade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Grade not found for studentId: " + studentId + ", courseId: " + courseId));
        return apply(grade);
    }

    public List<GradeDTO> getGradesByStudent(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        return grades.stream().map(GradeService::apply).collect(Collectors.toList());
    }
}