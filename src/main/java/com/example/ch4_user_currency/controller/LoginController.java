package com.example.ch4_user_currency.controller;

import com.example.ch4_user_currency.config.Const;
import com.example.ch4_user_currency.dto.LoginRequestDto;
import com.example.ch4_user_currency.dto.UserRequestDto;
import com.example.ch4_user_currency.dto.UserResponseDto;
import com.example.ch4_user_currency.entity.User;
import com.example.ch4_user_currency.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.controller
 * <li>fileName       : LoginController
 * <li>date           : 24. 11. 28.
 * <li>description    : 로그인 관리 컨트롤러
 * </ul>
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    /**
     * 신규 유저 등록
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(loginService.save(userRequestDto), HttpStatus.CREATED);
    }

    /**
     * 로그인
     *
     * @param dto 유저 이메일
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> login(
            @Valid @RequestBody LoginRequestDto dto,
            HttpServletRequest request
    ) {
        User loginUser = loginService.login(dto.getEmail());

        HttpSession session = request.getSession();
        session.setAttribute(Const.LOGIN_USER, loginUser);

        return ResponseEntity.ok().body(new UserResponseDto(loginUser));
    }
}
