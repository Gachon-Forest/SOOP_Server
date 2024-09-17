package com.example.soop.domain.user.service;

import com.example.soop.domain.user.entity.User;
import com.example.soop.domain.user.web.dto.UserRequestDTO;

public interface UserCommandService {
    User signUp(UserRequestDTO.SignUpRequestDTO request);
}
