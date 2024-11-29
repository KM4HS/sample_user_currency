package com.example.ch4_user_currency.filter;

import com.example.ch4_user_currency.config.Const;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.filter
 * <li>fileName       : LoginFilter
 * <li>date           : 24. 11. 28.
 * <li>description    : 로그인 필터
 * </ul>
 */


public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/login", "/login/register", "/currencies"};

    /**
     * 로그인이 필요한 uri 대상으로 필터링
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 로그인 체크가 필요한 URI인 경우
        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute(Const.LOGIN_USER) == null) {
                httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), Const.LOGIN_USER);
                return;
            }
        }

        chain.doFilter(request, httpResponse);
    }

    /**
     * URI가 {@code WHITE_LIST}에 포함되어있는가를 확인
     *
     * @param requestURI 요청 URI
     * @return {@code WHITE_LIST}에 포함된 경우 true
     */
    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
