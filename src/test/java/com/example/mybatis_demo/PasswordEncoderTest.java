package com.example.mybatis_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 密码匹配
    */
    @Test
    public  void  matchesPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String realPassword="123";
        String encodedPassword = encryptPassword(realPassword);

        System.out.println(encodedPassword);
        boolean rt =  passwordEncoder.matches(realPassword, encodedPassword);
        System.out.println("matched?" +rt);
    }
}
