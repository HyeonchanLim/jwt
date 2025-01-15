package com.green.jwt.config.security;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // 메소드 빈 등록
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //시큐리티가 세션을 사용하지 않는다.
                .httpBasic(h -> h.disable()) //SSR(Server Side Rendering)이 아니다. 화면을 만들지 않을꺼기 때문에 비활성화 시킨다. 시큐리티 로그인창 나타나지 않을 것이다.
                .formLogin(form -> form.disable()) //SSR(Server Side Rendering)이 아니다. 폼로그인 기능 자체를 비활성화
                .csrf(csrf -> csrf.disable()) //SSR(Server Side Rendering)이 아니다. 보안관련 SSR 이 아니면 보안이슈가 없기 때문에 기능을 끈다.
                .build();
    }
}
