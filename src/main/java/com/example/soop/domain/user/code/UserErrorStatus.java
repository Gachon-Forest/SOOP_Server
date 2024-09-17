package com.example.soop.domain.user.code;

import com.example.soop.global.exception.code.ApiCodeDto;
import com.example.soop.global.exception.code.ApiErrorCodeInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorStatus implements ApiErrorCodeInterface {

    // 가장 일반적인 응답
    _USER_ID_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER4001", "존재하지 않는 ID 입니다."),
    _USER_PW_INVALID(HttpStatus.BAD_REQUEST, "USER4002", "잘못된 PW 입니다."),
    _USER_ID_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "USER4003", "이미 존재하는 ID 입니다."),

    ;

    private final HttpStatus httpStatus;
    private final boolean isSuccess = false;
    private final String code;
    private final String message;

    @Override
    public ApiCodeDto getErrorCode() {
        return ApiCodeDto.builder()
                .httpStatus(httpStatus)
                .isSuccess(isSuccess)
                .code(code)
                .message(message)
                .build();
    }
}