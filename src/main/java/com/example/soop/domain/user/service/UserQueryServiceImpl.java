package com.example.soop.domain.user.service;

import com.example.soop.domain.user.code.UserErrorStatus;
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
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    @Override
    public User signIn(UserRequestDTO.SignInRequestDTO request) {

        User user = userRepository.findByUserID(request.getUserID())
                .orElseThrow(()->new RestApiException(UserErrorStatus._USER_ID_NOT_FOUND));

        if (user != null && user.getUserPW().equals(request.getUserPW())) {
            return user;
        } else {
            throw new RestApiException(UserErrorStatus._USER_PW_INVALID);
        }
    }
}
