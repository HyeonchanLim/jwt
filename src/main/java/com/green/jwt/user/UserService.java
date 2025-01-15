package com.green.jwt.user;

import com.green.jwt.user.model.UserSignUpReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public int signUp(UserSignUpReq req){
        String hashedPw = passwordEncoder.encode(req.getPw());
        req.setPw(hashedPw);
        mapper.insUser(req);
        mapper.insUserRole(req);
        return 1;
    }

}
