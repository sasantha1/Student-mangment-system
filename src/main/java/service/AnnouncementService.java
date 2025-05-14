package com.student.managementsystem.service;

import com.student.managementsystem.dto.AnnouncementDTO;
import com.student.managementsystem.entity.Announcement;
import com.student.managementsystem.entity.Teacher;
import com.student.managementsystem.exception.ResourceNotFoundException;
import com.student.managementsystem.repository.AnnouncementRepository;
import com.student.managementsystem.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final TeacherRepository teacherRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository, TeacherRepository teacherRepository) {
        this.announcementRepository = announcementRepository;
        this.teacherRepository = teacherRepository;
    }

    private static AnnouncementDTO apply(Announcement announcement) {
        AnnouncementDTO dto = new AnnouncementDTO();
        dto.setId(announcement.getId());
        dto.setTeacherId(announcement.getTeacher().getId());
        dto.setTeacherName(announcement.getTeacher().getFullName());
        dto.setTitle(announcement.getTitle());
        dto.setContent(announcement.getContent());
        dto.setPostedAt(announcement.getPostedAt());
        return dto;
    }

    public List<AnnouncementDTO> getRecentAnnouncements() {
        List<Announcement> announcements = announcementRepository.findTop10ByOrderByPostedAtDesc();
        return announcements.stream().map(AnnouncementService::apply).collect(Collectors.toList());
    }

    public void createAnnouncement(Long teacherId, String title, String content) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + teacherId));
        Announcement announcement = new Announcement();
        announcement.setTeacher(teacher);
        announcement.setTitle(title);
        announcement.setContent(content);
        announcement.setPostedAt(LocalDateTime.now());
        announcementRepository.save(announcement);
    }
}