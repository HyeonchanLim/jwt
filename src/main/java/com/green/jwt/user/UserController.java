package com.green.jwt.user;

import com.green.jwt.user.model.UserSignInReq;
import com.green.jwt.user.model.UserSignInRes;
import com.green.jwt.user.model.UserSignUpReq;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService service;

    @PostMapping("sign-up")
    public long signUp(@RequestBody UserSignUpReq req){
        log.info("Sign up request: {}",req);
        service.signUp(req);
        return req.getId();
    }

    @PostMapping("sign-in")
    public UserSignInRes signIn(@RequestBody UserSignInReq req , HttpServletResponse response){
        log.info("Sign in request: {}",req);

        return service.signIn(req,response);
    }

    /*
    url 이 /api/user/access-token 이어야 한다. 왜냐하면 RefreshToken 을 Cookie 에
    path 설정을 위 url 로 하였기 때문
     */
    @GetMapping("access-token")
    public String getAccessToken(HttpServletRequest req){
        return service.getAccessToken(req);
    }

    @GetMapping
    public String get(){
        return "user";
    }


}
