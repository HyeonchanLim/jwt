package com.green.jwt.user;

import com.green.jwt.user.model.UserSelOne;
import com.green.jwt.user.model.UserSignInReq;
import com.green.jwt.user.model.UserSignUpReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    int insUser(UserSignUpReq req);
    int insUserRole (UserSignUpReq req);
    Optional<UserSelOne> selUserWithRoles(UserSignInReq req);
    // 한가지만 받는 경우에는 Optional 쓰는 방법 추천
    // null 체크를 위한 if 문 없이 nullpointerexception 발생 처리함
}
