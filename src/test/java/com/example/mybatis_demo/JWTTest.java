package com.example.mybatis_demo;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

/**
 * 可能出现的常见日常：
 * SignatureVerificationException: 签名不一致异常
 * TokenExpiredException: 令牌过期异常
 * AlgorithmMismatchException: 算法不匹配异常
 * InvalidClaimException: 失效的payload异常

 *
 */
@SpringBootTest
public class JWTTest {
        /**
         * 生成token
         */
        @Test
        public void createTest(){
            Calendar instance = Calendar.getInstance();
            instance.add(Calendar.SECOND, 90);
            String token = JWT.create().withClaim("username", "mcf")
                    .withClaim("admin", true)
//                设置过期时间
                    .withExpiresAt(instance.getTime())
//                设置签名
                    .sign(Algorithm.HMAC256("token!Q2W#E$RW"));

            System.out.println(token);
        }


        /**
         * 解析token，输出相关信息
         */
        @Test
        public void paraseInfo(){
            //d4046485-8ef5-44d6-8b15-d8a2436edaa9
            JWTVerifier build = JWT.require(Algorithm.HMAC256("token!Q2W#E$RW")).build();
            DecodedJWT verify = build.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhZG1pbiI6dHJ1ZSwiZXhwIjoxNjUxMTk4Mzg3LCJ1c2VybmFtZSI6Im1jZiJ9.tH5-qe60SUmBC_7cO-QJv-86PURd3QkiGYVhBafZs-I");
            System.out.println(verify.getClaim("username").asString());
            System.out.println(verify.getClaim("admin").asBoolean());
        }



}
/**
 *
 * Authentication接口: 它的实现类，表示当前访问系统的用户，封装了用户相关信息。
 *
 * AuthenticationManager接口：定义了认证Authentication的方法
 *
 * UserDetailsService接口：加载用户特定数据的核心接口。里面定义了一个根据用户名查询用户信息的方法。
 *
 * UserDetails接口：提供核心用户信息。通过UserDetailsService根据用户名获取处理的用户信息要封装成UserDetails对象返回。然后将这些信息封装到Authentication对象中。
 *
 *2.3.1 思路分析
 *
 * 登录
 *
 *  ①自定义登录接口
 *
 *   调用ProviderManager的方法进行认证 如果认证通过生成jwt
 *
 *  把用户信息存入redis中
 *
 *   ②自定义UserDetailsService
 *
 *  在这个实现类中去查询数据库
 *
 * 校验：
 *
 *   ①定义Jwt认证过滤器
 *
 *  获取token
 *
 *   解析token获取其中的userid
 *
 *   从redis中获取用户信息
 *
 *  存入SecurityContextHolder
 *
 * ————————————————
 * 版权声明：本文为CSDN博主「生活是网」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/songt1122/article/details/125651825
 *
 *
 */
