package com.green.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private JwtConst jwtConst;
    @Test
    void objJwtConst(){
        System.out.println(jwtConst);
    }

}
