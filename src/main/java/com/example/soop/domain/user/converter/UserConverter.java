package com.example.soop.domain.user.converter;

import com.example.soop.domain.user.entity.User;
import com.example.soop.domain.user.web.dto.UserRequestDTO;
import com.example.soop.domain.user.web.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static User toUser(UserRequestDTO.SignUpRequestDTO request) {
        return User.builder()
                .name(request.getName())
                .userID(request.getUserID())
                .userPW(request.getUserPW())
                .build();
    }

    public static UserResponseDTO.SignUpResponseDTO toSignUpResponseDTO(User user) {
        return UserResponseDTO.SignUpResponseDTO.builder()
                .id(user.getId())
                .build();
    }

    public static UserResponseDTO.SignInResponseDTO toSignInResponseDTO(User user) {
        return UserResponseDTO.SignInResponseDTO.builder()
                .id(user.getId())
                .build();
    }
}
