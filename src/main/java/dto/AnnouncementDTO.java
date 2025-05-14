package com.student.managementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {
    private Long id;
    private Long teacherId;
    private String teacherName; // For display
    private String title;
    private String content;
    private LocalDateTime postedAt;
}