package com.example.ch4_user_currency.dto;

import com.example.ch4_user_currency.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 10, message = "이름은 최대 10글자까지 입력 가능합니다.")
    private String name;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Pattern(
            regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "이메일 형식이 맞지 않습니다."
    )
    private String email;

    public User toEntity() {
        return new User(
                this.name,
                this.email
        );
    }
}
