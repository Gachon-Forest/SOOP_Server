package com.example.soop.domain.user.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class UserRequestDTO {

    @Schema(description = "회원가입 DTO")
    @Getter
    @RequiredArgsConstructor
    public static class SignUpRequestDTO {
        @Schema(description = "사용자 이름")
        @Pattern(regexp = "^[가-힣a-zA-Z]+$", message = "숫자나 특수문자는 사용할 수 없습니다.")
        @Size(min = 1, max = 10, message = "이름은 10자 이내로 입력해주세요.")

        private String name;

        @Schema(description = "사용자 id")
        @Size(min = 4, max = 10, message = "id는 10자 이내로 입력해주세요.")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "영문자와 숫자만 입력 가능합니다.")
        private String userID;

        @Schema(description = "사용자 pw")
        @Size(min = 8, max = 20, message = "pw는 20자 이내로 입력해주세요.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#])[A-Za-z\\d!@#]{8,}$", message = "비밀번호는 최소 8자 이상, 문자, 숫자, 특수문자(!, @, *)를 각각 하나 이상 포함해야 합니다.")
        private String userPW;
    }

    @Schema(description = "로그인 DTO")
    @Getter
    @RequiredArgsConstructor
    public static class SignInRequestDTO {
        @Schema(description = "사용자 id")
        @Size(min = 4, max = 10, message = "id는 10자 이내로 입력해주세요.")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "영문자와 숫자만 입력 가능합니다.")
        private String userID;

        @Schema(description = "사용자 pw")
        @Size(min = 8, max = 20, message = "pw는 20자 이내로 입력해주세요.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#])[A-Za-z\\d!@#]{8,}$", message = "비밀번호는 최소 8자 이상, 문자, 숫자, 특수문자(!, @, *)를 각각 하나 이상 포함해야 합니다.")
        private String userPW;
    }
}
