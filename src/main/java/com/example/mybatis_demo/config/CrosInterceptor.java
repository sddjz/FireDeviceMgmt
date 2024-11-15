package com.example.mybatis_demo.config;

import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CrosInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {



        // 如果是OPTIONS则结束请求
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            // 此处配置的是允许任意域名跨域请求，可根据需求指定
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
            response.setHeader("Access-Control-Max-Age", "86400");
            response.setHeader("Access-Control-Allow-Headers", "*");

            response.setStatus(HttpStatus.NO_CONTENT.value());
            return false;
        }

        /** can get the data;
         *    try {
         *             String requestStr = IOUtils.toString(request.getInputStream());
         *             System.out.println("-----------------------------"+requestStr);
         *         }catch(Exception e){
         *             System.out.println("read input stream failed");
         *         }
         */

        return true;
    }

}
