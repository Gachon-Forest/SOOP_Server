package com.example.soop.domain.user.web.controller;

import com.example.soop.domain.user.converter.UserConverter;
import com.example.soop.domain.user.entity.User;
import com.example.soop.domain.user.service.UserCommandService;
import com.example.soop.domain.user.service.UserQueryService;
import com.example.soop.domain.user.web.dto.UserRequestDTO;
import com.example.soop.domain.user.web.dto.UserResponseDTO;
import com.example.soop.global.base.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입 API", description = "회원가입하는 API 입니다.")
    public ApiResponse<UserResponseDTO.SignUpResponseDTO> signUp(@RequestBody UserRequestDTO.SignUpRequestDTO request) {
        User user = userCommandService.signUp(request);
        UserResponseDTO.SignUpResponseDTO responseDTO = UserConverter.toSignUpResponseDTO(user);
        return ApiResponse.onSuccess(responseDTO);
    }

    @PostMapping("/login")
    @Operation(summary = "로그인 API", description = "로그인하는 API 입니다.")
    public ApiResponse<UserResponseDTO.SignInResponseDTO> signIn(@RequestBody UserRequestDTO.SignInRequestDTO request) {
        User user = userQueryService.signIn(request);
        UserResponseDTO.SignInResponseDTO responseDTO = UserConverter.toSignInResponseDTO(user);
        return ApiResponse.onSuccess(responseDTO);
    }
}
