package com.example.soop.domain.user.service;

import com.example.soop.domain.user.code.UserErrorStatus;
import com.example.soop.domain.user.converter.UserConverter;
import com.example.soop.domain.user.entity.User;
import com.example.soop.domain.user.repository.UserRepository;
import com.example.soop.domain.user.web.dto.UserRequestDTO;
import com.example.soop.global.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    @Override
    public User signUp(UserRequestDTO.SignUpRequestDTO request) {

        if (userRepository.existsByUserID(request.getUserID())) {
            throw new RestApiException(UserErrorStatus._USER_ID_ALREADY_EXIST);
        }

        User user = UserConverter.toUser(request);

        userRepository.save(user);
        return user;
    }
}
