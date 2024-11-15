package com.example.mybatis_demo.config;

import com.example.mybatis_demo.component.JWTAuthenticationTokenFilter;
import com.example.mybatis_demo.entity.auth.LoginUser;
import com.example.mybatis_demo.service.auth.LoginService;
import com.example.mybatis_demo.service.impl.auth.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.Arrays;
import java.util.Collections;

//inject authenticationManager;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private LoginService adminService;

    /**
    @Autowired
    private CrosFilter crosFilter;


    @Bean
    public CrosFilter getCrosFilterBean(){
        return new CrosFilter();
    }*/



    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf()// 由于使用的是JWT，我们这里不需要csrf
                .disable()
                .sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.png",
                        "/**/*.jpg",
                        "/**/*.map",
                        "/druid/**",
                        "/favicon.ico",
                        "/actuator/**",
                        "/swagger-resources/**",
                        "/swagger-ui/",
                        "/v2/api-docs/**",
                        "/admin/login",
                        "/admin/register",
                        "/admin/info",
                        "/admin/logout",
                        "/minio/upload"

                )
                .permitAll()
                .antMatchers("/admin/login", "/admin/register")// 对登录注册要允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated();
        /**
         *   .antMatchers("/**")//测试时全部运行访问
               .permitAll()
         */

        httpSecurity.cors().and().csrf().disable().headers().frameOptions().disable();

        // 禁用缓存
        httpSecurity.headers().cacheControl();
        //httpSecurity.addFilterBefore(crosFilter,jwtAuthenticationTokenFilter().getClass());
        // 添加JWT filter
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);

        //disable reading HSTS  while https is not supported in server side.
        httpSecurity.headers().httpStrictTransportSecurity().disable();


    }

    /**
     *
     *
     *
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        /**
         *         httpSecurity.csrf().addMapping("/**").allowedOrigins("Http://localhost:8080","null")
         *                 .allowedMethods("GET","POST","OPTIONS","DELETE")
         */
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));

        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);
        return source;
        /**
         *
         *   CorsConfiguration configuration = new CorsConfiguration();
         *     configuration.setAllowedOrigins(Collections.singletonList("*"));
         *     configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
         *     configuration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
         *     configuration.setAllowCredentials(true);
         *     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         *     source.registerCorsConfiguration("/**", configuration);
         *     return source;
         */
    }
/**
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }
 */


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
    @Bean
    public LoginService userDetailsService() {
        //获取登录用户信息
        return username -> {
            LoginUser admin = adminService.getAdminByUsername(username);
            if (admin != null) {
                List<UmsPermission> permissionList = adminService.getPermissionList(admin.getId());
                return new LoginServiceImpl(admin,permissionList);
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }*/

    @Bean
    public JWTAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JWTAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



}
