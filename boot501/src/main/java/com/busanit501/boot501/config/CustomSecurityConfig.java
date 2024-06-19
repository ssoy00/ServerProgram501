package com.busanit501.boot501.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Log4j2
@Configuration
@RequiredArgsConstructor
// 어노테이션을 이용해서, 특정 권한 있는 페이지 접근시, 구분가능.
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableMethodSecurity
@EnableWebSecurity
public class CustomSecurityConfig {

    // 평문 패스워드를 해시 함수 이용해서 인코딩 해주는 도구 주입.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("시큐리티 동작 확인 ====CustomSecurityConfig======================");
        // 로그인 없이 자동 로그인 확인
        // 빈 설정.
        // 인증 관련된 설정.
        http.formLogin(
                formLogin -> formLogin.loginPage("/member/login").permitAll()
        );
        ;

        http.authorizeRequests()
                .requestMatchers("/css/**", "/js/**","/image/**").permitAll()
                .requestMatchers("/", "/main", "/login", "/joinUser","/joinForm","/findAll","/images/**").permitAll()
                .requestMatchers("/admin","/images").hasRole("ADMIN")
                .anyRequest().authenticated()
        ;

        return http.build();
    }

    //정적 자원 시큐리티 필터 항목에 제외하기.
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        log.info("시큐리티 동작 확인 ====webSecurityCustomizer======================");
        return (web) ->
                web.ignoring()
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

}
