package com.example.ch4_user_currency.service;

import com.example.ch4_user_currency.dto.UserRequestDto;
import com.example.ch4_user_currency.dto.UserResponseDto;
import com.example.ch4_user_currency.entity.User;
import com.example.ch4_user_currency.exception.CustomException;
import com.example.ch4_user_currency.exception.ErrorCode;
import com.example.ch4_user_currency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.service
 * <li>fileName       : LoginService
 * <li>date           : 24. 11. 28.
 * <li>description    : 로그인 비즈니스 로직
 * </ul>
 */

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    /**
     * 유저 등록
     */
    @Transactional
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User savedUser = userRepository.save(userRequestDto.toEntity());
        return new UserResponseDto(savedUser);
    }

    /**
     * 로그인
     * @param email 유저 이메일
     */
    public User login(String email) {
        User findUser = userRepository.findUserByEmail(email);
        if(findUser == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        return findUser;
    }
}
