package com.example.ch4_user_currency.controller;

import com.example.ch4_user_currency.config.Const;
import com.example.ch4_user_currency.dto.ExchangeGroupResponseDto;
import com.example.ch4_user_currency.dto.ExchangeRequestDto;
import com.example.ch4_user_currency.dto.ExchangeResponseDto;
import com.example.ch4_user_currency.service.ExchangeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.controller
 * <li>fileName       : ExchangeController
 * <li>date           : 24. 11. 28.
 * <li>description    : 환전 요청 관리를 위한 컨트롤러
 * </ul>
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/exchange")
public class ExchangeController {

    private final ExchangeService exchangeService;

    /**
     * 환전 요청 생성
     *
     * @param dto 요청 정보가 담긴 dto
     */
    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchange(
            @Valid @RequestBody ExchangeRequestDto dto,
            @SessionAttribute(name = Const.LOGIN_USER) Long sessionKey
    ) {
        ExchangeResponseDto responseDto = exchangeService.createExchange(sessionKey, dto.getCurrencyId(), dto.getAmountInKrw());
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    /**
     * 유저별 환전 요청 조회
     *
     * @param sessionKey 유저 식별자
     */
    @GetMapping
    public ResponseEntity<List<ExchangeResponseDto>> findExchangesByUser(
            @SessionAttribute(name = Const.LOGIN_USER) Long sessionKey
    ) {
        List<ExchangeResponseDto> exchangesByUserDto = exchangeService.findExchangesByUser(sessionKey);
        return new ResponseEntity<>(exchangesByUserDto, HttpStatus.OK);
    }

    /**
     * 유저의 환전 요청을 요청 횟수, 요청 총액으로 그룹화
     *
     * @param sessionKey 유저 식별자
     */
    @GetMapping("/group")
    public ResponseEntity<ExchangeGroupResponseDto> findExchangeInGroup(
            @SessionAttribute(name = Const.LOGIN_USER) Long sessionKey
    ) {
        ExchangeGroupResponseDto exchangeInGroup = exchangeService.findExchangeInGroup(sessionKey);

        return ResponseEntity.ok().body(exchangeInGroup);
    }

    /**
     * 환전 취소 상태로 변경
     *
     * @param exchangeId 환전 요청 식별자
     */
    @PatchMapping("/{exchangeId}")
    public ResponseEntity<String> updateExchangeStatus(
            @PathVariable Long exchangeId
    ) {
        exchangeService.cancelExchange(exchangeId);

        return ResponseEntity.ok().body("정상적으로 취소되었습니다.");
    }
}
