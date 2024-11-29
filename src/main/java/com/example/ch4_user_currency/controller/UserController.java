package com.example.ch4_user_currency.controller;

import com.example.ch4_user_currency.config.Const;
import com.example.ch4_user_currency.dto.UserResponseDto;
import com.example.ch4_user_currency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@SessionAttribute(name = Const.LOGIN_USER) Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("정상적으로 삭제되었습니다.");
    }
}
