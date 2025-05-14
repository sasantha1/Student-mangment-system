package com.student.managementsystem.dto;

import com.student.managementsystem.entity.User.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password; // For registration only
    private String email;
    private Role role;
}