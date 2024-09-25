package com.gerenciatime.dtos;

import com.gerenciatime.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role){
}
