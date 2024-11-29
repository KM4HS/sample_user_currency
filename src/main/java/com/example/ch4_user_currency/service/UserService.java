package com.example.ch4_user_currency.service;

import com.example.ch4_user_currency.dto.UserResponseDto;
import com.example.ch4_user_currency.entity.User;
import com.example.ch4_user_currency.exception.CustomException;
import com.example.ch4_user_currency.exception.ErrorCode;
import com.example.ch4_user_currency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById(Long id) {
        return new UserResponseDto(findUserById(id));
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }

    @Transactional
    public void deleteUserById(Long id) {
        this.findUserById(id);
        userRepository.deleteById(id);
    }

}
