package com.example.ch4_user_currency.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.dto
 * <li>fileName       : LoginRequestDto
 * <li>date           : 24. 11. 28.
 * <li>description    : 로그인 요청 dto
 * </ul>
 */

@Getter
public class LoginRequestDto {

    @NotBlank(message = "이메일을 입력해주세요.")
    @Pattern(
            regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "이메일 형식이 맞지 않습니다."
    )
    private String email;
}
