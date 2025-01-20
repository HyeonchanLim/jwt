package com.green.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JwtApplication {

    public static void main(String[] args) {

        SpringApplication.run(JwtApplication.class, args);
    }

}
/*
Security 는 필터에서 작동
필터는 (1) 아무런 작업을 하지 않고 다음 필터에게 넘긴다.
      (2) 무슨 작업을 하고 다음 필터에게 넘긴다.
      (3) 문제가 있으면 다음 필터에게 넘기지 않고 바로 예외처리 응답을 한다.

- 로그인 : AT , RT 생성 , AT 는 BODY 로 리턴(응답) , RT 는 Cookie 에 담아서 리턴 (응답)
- 프론트는 AT 를 받은 순간부터 모든 요청의 HEADER 에 Authorization 키값으로 "Bearer ${AT}" 를 보내준다.
- 요청이 들어올 때마다 AT 체크를 한다. 현재 프로젝트 기준 TokenAuthenticationFilter 에서 담당
    (1) HEADER 의 Authorization 키가 있는지 확인 , 있으면 Bearer 를 뺀 AT 를 뽑아낸다.
      >> Token 이 유효하다면 Authentication 객체를 생성하고 SecurityContextHolder 에 담는다.
         (Spring Framework Security(SFS) 미들웨어 쓰는데 SFS 가 인증처리하는 방법)
         , 즉 모든 요청마다 Authentication 객체가 SecurityContextHolder 에 담겨있어야 인증이 되었다고 처리한다.
      >> Token 이 만료되었다면 예외를 발생한다. 403 을 응답함
    (2) 만약 HEADER 에 Authorization 키가 없었다면 아무런 작업을 안 한다.
      >> SFS 가 인증/인가 처리되는 URL 은 사용할 수 없게 된다.
      >> SFS 가 인증/인가가 필요없는 URL 은 사용할 수 있다.






 */
