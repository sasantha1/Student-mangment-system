package com.student.managementsystem.repository;

import com.student.managementsystem.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    List<Announcement> findTop10ByOrderByPostedAtDesc();
}