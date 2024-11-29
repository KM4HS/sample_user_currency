package com.example.ch4_user_currency.config;

import com.example.ch4_user_currency.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <ul>
 * <li>packageName    : com.example.ch4_user_currency.config
 * <li>fileName       : WebConfig
 * <li>date           : 24. 11. 28.
 * <li>description    : Controller 진입 전 필터 등록
 * </ul>
 */

public class WebConfig implements WebMvcConfigurer {

    /**
     * 로그인 필터 등록
     */
    @Bean
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
